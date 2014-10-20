package com.example.model;

public class GetbuddylistRequest extends MessageRequest{
	private int sendid = 0;
	public GetbuddylistRequest() {
		setAction("getbuddylist");
	}
	public int getSendid() {
		return sendid;
	}

	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	
}
