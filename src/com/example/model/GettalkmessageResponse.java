package com.example.model;

import java.util.List;

public class GettalkmessageResponse extends MessageResponse{
	private List<ChatMsgEntity> list = null;

	public List<ChatMsgEntity> getList() {
		return list;
	}

	public void setList(List<ChatMsgEntity> list) {
		this.list = list;
	}
	
}
