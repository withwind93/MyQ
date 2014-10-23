package com.example.model;

public class GettalkmessageRequest extends MessageRequest{
	private int sendid = 0;
	private int recvid = 0;
	public GettalkmessageRequest() {
		setAction("gettalkmessage");
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
}
