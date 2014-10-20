package com.example.model;

public class DeletebuddyRequest extends MessageRequest{
	private int sendid = 0;
	private int buddyid = 0;
	public DeletebuddyRequest(){
		setAction("deletebuddy");
	}
 	
	public int getSendid() {
		return sendid;
	}
	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	public int getBuddyid() {
		return buddyid;
	}
	public void setBuddyid(int buddyid) {
		this.buddyid = buddyid;
	}
	
}
