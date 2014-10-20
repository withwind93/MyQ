package com.example.message;


import com.example.model.ConnectResponse;
import com.example.model.RegisterResponse;

public class InputSocket extends Thread {
	private MyQSocket socket = null;
	private static InputSocket instance = null;

	/**
	 * 私有默认构造子
	 */
	private InputSocket() {
		socket = MyQSocket.getInstance();
	}

	/**
	 * 静态工厂方法
	 */
	public static InputSocket getInstance() {
		if (instance == null) {
			instance = new InputSocket();
		}
		return instance;
	}

	@Override
	public void run() {
		while (true) {
			byte[] by = new byte[1024];
			int length = 0;
			try {
				while ((length = socket.getSocket().getInputStream().read(by)) == -1) {
					sleep(10);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String string = new String(by, 0, length);
			if (getCommand(string).equals("connect")) {
				System.out.println("-----connect-----");
				ConnectResponse connectResponse = (ConnectResponse) JSonUtils
						.readValue(string, ConnectResponse.class);
				if (connectResponse.getOk().equals("ok")) {
					System.out.println("-----connect ok-----");
					socket.setToken(connectResponse.getToken());
					System.out.println("-----token : " + socket.getToken() + "-----");
				}
			} else if (getCommand(string).equals("register")) {
				System.out.println("-----register-----");
				RegisterResponse registerResponse = JSonUtils.readValue(string, RegisterResponse.class);
				System.out.println("新号码 :" + registerResponse.getMessage());
			}
		}
	}

	private String getCommand(String s) {
		String result = null;
		int index = s.indexOf("\"action\":\"") + 10;
		int lastindex = s.indexOf("\"", index);
		result = s.substring(index, lastindex);
		return result;
	}
}
