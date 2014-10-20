package com.example.model;

public class RegisterRequest extends MessageRequest{
	private String nickname = null;
	private String password = null;
	public RegisterRequest() {
		setAction("register");
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
