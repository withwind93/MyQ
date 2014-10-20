package com.example.model;

public class LoginRequest extends MessageRequest{
	private int sendid = 0;
	private String password = null;
	public LoginRequest(){
		setAction("login");
	}
	public int getSendid() {
		return sendid;
	}
	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
