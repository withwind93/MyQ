package com.example.model;

public class MessageRequest {
	public String type = "request";
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String action = null;
	public String token = null;
}
