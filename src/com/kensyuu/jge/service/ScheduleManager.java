package com.kensyuu.jge.service;

import java.util.List;

import com.kensyuu.jge.bean.Schedule;
import com.kensyuu.jge.dataaccess.ScheduleDao;

public class ScheduleManager {

	public List<Schedule> findScheduleByGroupId(int groupId){
		ScheduleDao sd = new ScheduleDao();
		List<Schedule> scheduleList = sd.findScheduleByGroupId(groupId);
		return scheduleList;
	}

	public void addSchedule(Schedule schedule) {
		ScheduleDao sd = new ScheduleDao();
		sd.addSchedule(schedule);
	}

}
