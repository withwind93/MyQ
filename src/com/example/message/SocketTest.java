package com.example.message;

public class SocketTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputSocket.getInstance().start();
		OutputSocket.getInstance().start();
		while(MyQSocket.getInstance().getToken() == null);
		
	}
}
