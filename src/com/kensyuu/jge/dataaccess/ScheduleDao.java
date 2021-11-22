package com.kensyuu.jge.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kensyuu.jge.bean.Schedule;
import com.kensyuu.jge.util.StringUtils;

public class ScheduleDao {

	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/schedule";
	private final String DB_USER = "root";
	private final String DB_PASS = "tomo7292";

	public List<Schedule> findScheduleByGroupId(int groupId){
		Connection conn = null;
		PreparedStatement pStmt = null;
		List<Schedule>scheduleList = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String SQL = "SELECT "
							+ "date, "
							+ "startTime, "
							+ "endTime, "
							+ "title, "
							+ "place "
						+ "FROM "
							+ "schedules "
						+ "WHERE "
							+ "groupId = ? "
						+ "ORDER BY "
							+ "date ASC, "
							+ "startTime ASC";

			pStmt = conn.prepareStatement(SQL);
			pStmt.setInt(1, groupId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Schedule sc = new Schedule();
				sc.setDate(rs.getString("date"));
				sc.setStartTime(rs.getString("startTime"));
				sc.setEndTime(rs.getString("endTime"));
				sc.setTitle(rs.getString("title"));
				sc.setPlace(rs.getString("place"));
				scheduleList.add(sc);
			 }
			 rs.close();
			 pStmt.close();
			 conn.close();
			}catch(SQLException e) {
				 e.printStackTrace();
				 return null;
			 }
		 return scheduleList;
	}

	public void addSchedule(Schedule schedule) {
		Connection conn = null;
		PreparedStatement pStmt = null;

		try {
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			String SQL = "INSERT INTO "
							+ "schedules "
							+ "(groupId, "
							+ "date, "
							+ "startTime, "
							+ "endTime, "
							+ "title, "
							+ "place) "
						+ "VALUES "
							+ "(?, "
							+ "?, "
							+ "?, "
							+ "?, "
							+ "?, "
							+ "?)";

			StringUtils.toHtmlString(schedule.getTitle());
			StringUtils.toHtmlString(schedule.getPlace());

			pStmt = conn.prepareStatement(SQL);
			pStmt.setInt(1, schedule.getGroupId());
			pStmt.setString(2, schedule.getDate());
			pStmt.setString(3, schedule.getStartTime());
			pStmt.setString(4, schedule.getEndTime());
			pStmt.setString(5, schedule.getTitle());
			pStmt.setString(6, schedule.getPlace());

			pStmt.executeUpdate();
			pStmt.close();
			conn.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
}
