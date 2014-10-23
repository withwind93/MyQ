package com.example.model;

public class BuddyEntity {
	private String id = null;

	public void setId(String id) {
		this.id = id;
	}

	private String name = null;

	public String getId() {
		return id;
	}

	public BuddyEntity() {

	}

	public BuddyEntity(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
