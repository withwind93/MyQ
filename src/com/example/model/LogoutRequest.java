package com.example.model;

public class LogoutRequest extends MessageRequest{
	private int sendid = 0;
	public LogoutRequest(){
		setAction("logout");
	}
	public int getSendid() {
		return sendid;
	}

	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	
}
