package com.example.model;

public class LoginResponse extends MessageResponse{
	private String ok = null;
	private String message = null;
	private String nickname = null;
	public String getOk() {
		return ok;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setOk(String ok) {
		this.ok = ok;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
