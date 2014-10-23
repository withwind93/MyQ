package com.example.model;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class ChatMsgEntity {
	private String message = null;
	private String time = null;
	public String getMessage() {
		try {
			message = URLDecoder.decode(message, "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
