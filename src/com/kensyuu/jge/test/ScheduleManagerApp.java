package com.kensyuu.jge.test;

import java.util.List;

import com.kensyuu.jge.bean.Schedule;
import com.kensyuu.jge.service.ScheduleManager;

public class ScheduleManagerApp {

	public static void main(String[] args) {
		ScheduleManager scheduleManager =
								new ScheduleManager();
		List<Schedule> scheduleList = null;
		scheduleList =
				scheduleManager.findScheduleByGroupId(1);
		for(Schedule schedule : scheduleList) {
			System.out.print("日付:" + schedule.getDate() + "\t");
			System.out.print("開始:" + schedule.getStartTime() + "\t");
			System.out.print("終了:" + schedule.getEndTime() + "\t");
			System.out.print("用件:" + schedule.getTitle() + "\t");
			System.out.println("場所:" + schedule.getPlace() + "\t");
		}
	}
}
