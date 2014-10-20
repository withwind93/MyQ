package com.example.model;

public class ConnectResponse extends MessageResponse{
	private String ok = null;
	private String message = null;
	public String getOk() {
		return ok;
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
