package com.example.model;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class SendRequest extends MessageRequest{
	private int sendid = 0;
	private int recvid = 0;
	private String msgtype = null;
	private String message = null;
	public SendRequest() {
		setAction("send");
	}
	public int getSendid() {
		return sendid;
	}
	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	public int getRecvid() {
		return recvid;
	}
	public void setRecvid(int recvid) {
		this.recvid = recvid;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
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
		try {
			message = URLEncoder.encode(message, "utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.message = message;
	}
}
