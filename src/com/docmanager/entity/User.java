package com.docmanager.entity;


public class User {
	
	private int uid;
	private String name;
	private String password;


	public User() {
		
	}
	
	public User(User user) {
		this.uid = user.getUid();
		this.name = user.getName();
	}
	
	
	public User(String name, String password) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.password=password;
	}

	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
