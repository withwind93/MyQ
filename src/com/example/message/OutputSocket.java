package com.example.message;
import java.io.OutputStream;
import com.example.model.MessageRequest;

public class OutputSocket extends Thread {
	private MyQSocket socket = null;
	private static OutputSocket instance = null;
	private Object outputObject = null;
	volatile private String messageRequest = null;
	
	public Object getOutputObject() {
		return outputObject;
	}

	public void setOutputObject(Object outputObject) {
		this.outputObject = outputObject;
	}

	/**
	 * 私有默认构造子
	 */
	private OutputSocket() {
		socket = MyQSocket.getInstance();
	}

	/**
	 * 静态工厂方法
	 */
	public static OutputSocket getInstance() {
		if (instance == null) {
			instance = new OutputSocket();
		}
		return instance;
	}

	@Override
	public void run() {
		while (true) {
			OutputStream os;
			try {
				while(socket.getSocket() == null) sleep(10);
				os = socket.getSocket().getOutputStream();
				while(messageRequest == null) sleep(10);
				os.write(messageRequest.getBytes());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(messageRequest);
			messageRequest = null;
		}
	}

	public String getMessageRequest() {
		return messageRequest;
	}

	public void setMessageRequest(MessageRequest messageRequest) {
		messageRequest.setToken(socket.getToken());
		this.messageRequest = JSonUtils.toJSon(messageRequest);
	}
}
