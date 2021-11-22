package com.kensyuu.jge.test;

import com.kensyuu.jge.bean.GroupAccount;
import com.kensyuu.jge.service.GroupAccountManager;

public class GroupAccountManagerApp {

	/**
	 * <pre>
	 * GroupAccountManagerクラスの動作を確認するためのクラス
	 * </pre>
	 * @param args
	 */
	public static void main(String[] args) {
		testCase01();
		testCase02();
		testCase03();
		testCase04();
	}

	public static void testCase01() {
		System.out.println("testCase01()---------------");

		String groupName = "kensyuu";
		String password = "kenpass1";

		GroupAccountManager groupAccountManager = new GroupAccountManager();
		GroupAccount groupAccount = groupAccountManager.findGroupAccountManager(groupName, password);

		if(groupAccount != null) {
			System.out.println("グループ名：" + groupAccount.getGroupName());
			System.out.println("パスワード：" + groupAccount.getPassword());
		} else {
			System.out.println("グループアカウントがNULL");
		}
	}

	public static void testCase02() {
		System.out.println("testCase02()---------------");

		String groupName = "kensyuu";
		String password = "kenpass2";

		GroupAccountManager groupAccountManager = new GroupAccountManager();
		GroupAccount groupAccount = groupAccountManager.findGroupAccountManager(groupName, password);

		if(groupAccount != null) {
			System.out.println("グループ名：" + groupAccount.getGroupName());
			System.out.println("パスワード：" + groupAccount.getPassword());
		} else {
			System.out.println("グループアカウントがNULL");
		}
	}

	public static void testCase03(){
		System.out.println("testCase03()---------------");

		String groupName = "kensyuu2";
		String password = "kenpass1";

		GroupAccountManager groupAccountManager = new GroupAccountManager();
		GroupAccount groupAccount = groupAccountManager.findGroupAccountManager(groupName, password);

		if(groupAccount != null) {
			System.out.println("グループ名：" + groupAccount.getGroupName());
			System.out.println("パスワード：" + groupAccount.getPassword());
		} else {
			System.out.println("グループアカウントがNULL");
		}
	}

	public static void testCase04() {
		System.out.println("testCase04()---------------");

		String groupName = "kensyuu2";
		String password = "kenpass2";

		GroupAccountManager groupAccountManager = new GroupAccountManager();
		GroupAccount groupAccount = groupAccountManager.findGroupAccountManager(groupName, password);

		if(groupAccount != null) {
			System.out.println("グループ名：" + groupAccount.getGroupName());
			System.out.println("パスワード：" + groupAccount.getPassword());
		} else {
			System.out.println("グループアカウントがNULL");
		}
	}
}
