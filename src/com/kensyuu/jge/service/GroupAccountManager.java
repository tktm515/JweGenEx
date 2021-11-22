package com.kensyuu.jge.service;

import com.kensyuu.jge.bean.GroupAccount;
import com.kensyuu.jge.dataaccess.GroupAccountDao;

public class GroupAccountManager {

	public GroupAccount findGroupAccountManager(String groupName, String password){
		GroupAccountDao gad = new GroupAccountDao();
		GroupAccount ga = gad.findGroupAccountManager(groupName, password);
		if( ga != null) {
			return ga;
		}else {
			return null;
		}
	}

}
