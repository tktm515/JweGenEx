package com.kensyuu.jge.bean;

import java.util.ArrayList;
import java.util.List;

import com.kensyuu.jge.util.ValidateUtils;

public class Schedule {

	private int id;
	private int groupId;
	private String date;
	private String startTime;
	private String endTime;
	private String title;
	private String place;

	public Schedule() {}
	public Schedule(String date, String startTime, String endTime, String title, String place) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.place = place;
	}
	public Schedule(int id, int groupId, String date, String startTime, String endTime, String title, String place) {
		this.id = id;
		this.groupId = groupId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.place = place;
	}

	public List<String> validate(){
		int min = 1;
		int max = 65;
		ValidateUtils vdu = new ValidateUtils();
		List<String>emgList = new ArrayList<>();
		vdu.isDateFormat(date);
		vdu.isTimeFormat(startTime);
		vdu.isTimeFormat(endTime);
		vdu.isRengeLength(title, min, max);
		vdu.isRengeLength(place, min, max);
		if(vdu.isDateFormat(date) != true) {
			emgList.add("日付は、YYYY/MM/DDのフォーマットで入力してください。");
		}
		if(vdu.isTimeFormat(startTime) != true) {
			emgList.add("開始時刻は、hh:mmのフォーマットで入力してください。");
		}
		if(vdu.isTimeFormat(endTime) != true) {
			emgList.add("終了時刻は、hh:mmのフォーマットで入力してください。");
		}
		if(vdu.isRengeLength(title, min, max) != true) {
			emgList.add("用件は、半角1文字以上、64文字以内で入力してください。");
		}
		if(vdu.isRengeLength(place, min, max) != true) {
			emgList.add("場所は、半角1文字以上、64文字以内で入力してください。");
		}
		return emgList;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}


}
