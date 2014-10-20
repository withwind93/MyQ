package com.example.message;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyQSocket {

	volatile private Socket socket = null;
	private String token = null;
    
	private static MyQSocket instance = null;
    /**
     * ˽��Ĭ�Ϲ�����
     */
    private MyQSocket(){
    	try {
			socket = new Socket();
			try{
				socket.connect(new InetSocketAddress("104.131.85.91",9999),10000);
			}catch(SocketTimeoutException e){
				System.out.println("���������ӳ�ʱ��");
				return ;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    /**
     * ��̬��������
     */
    public static MyQSocket getInstance(){
    	if (instance == null) {
			instance = new MyQSocket();
		}
        return instance;
    }
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Socket getSocket() {
		return socket;
	}

}
