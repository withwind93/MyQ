package com.example.message;

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
				Response.setConnect(string);
			} else if (getCommand(string).equals("register")) {
				System.out.println("-----register-----");
				Response.setRegisterResponse(string);
			} else if (getCommand(string).equals("addbuddy")) {
				System.out.println("-----addbuddy-----");
				Response.setAddbuddyResponse(string);
			} else if (getCommand(string).equals("deletebuddy")) {
				System.out.println("-----deletebuddy-----");
				Response.setDeletebuddyResponse(string);
			} else if (getCommand(string).equals("getbuddylist")) {
				System.out.println("-----getbuddylist-----");
				Response.setGetbuddylistResponse(string);
			} else if (getCommand(string).equals("login")) {
				System.out.println("-----login-----");
				System.out.println(string);
				Response.setLoginResponse(string);
			}else if (getCommand(string).equals("send")){
				System.out.println("-----receive-----");
				Response.setRecvResponse(string);
			}else if (getCommand(string).equals("gettalkmessage")){
				System.out.println("-----gettalkmessage-----");
				Response.setGettalkmessageResponse(string);
			}else {
				System.out.println("-----error-----");
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
