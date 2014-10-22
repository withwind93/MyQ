package com.example.model;

import java.util.List;

public class GetbuddylistResponse extends MessageResponse{
	private List<BuddyEntity> list = null;
	
	public List<BuddyEntity> getList() {
		return list;
	}
	public void setList(List<BuddyEntity> list) {
		this.list = list;
	}
}
