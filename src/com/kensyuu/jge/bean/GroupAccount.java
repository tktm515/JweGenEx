package com.kensyuu.jge.bean;

public class GroupAccount {

	int id = -1;
	String groupName;
	String password;

	public GroupAccount() {}
	public GroupAccount(String groupName, String password) {
		this.groupName = groupName;
		this.password = password;
	}
	public GroupAccount(int id, String groupName, String password) {
		this.id = id;
		this.groupName = groupName;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
