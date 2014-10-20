package com.example.model;

import java.util.List;

public class GetbuddylistResponse extends MessageResponse{
	private List<User> list = null;
	
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
}
