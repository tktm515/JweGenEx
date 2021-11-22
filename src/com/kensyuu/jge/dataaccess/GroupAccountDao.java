package com.kensyuu.jge.dataaccess;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kensyuu.jge.bean.GroupAccount;

public class GroupAccountDao implements Serializable {

	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/schedule";
	private final String DB_USER = "root";
	private final String DB_PASS = "tomo7292";

	public GroupAccount findGroupAccountManager(String groupName, String password) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		GroupAccount ga = null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

				String SQL = "SELECT "
								+ "id, "
								+ "name, "
								+ "password "
							+ "FROM "
								+ "groups "
							+ "WHERE "
								+ "name=? "
							+ "AND "
								+ "password=?";

				pStmt = conn.prepareStatement(SQL);
				pStmt.setString(1, groupName);
				pStmt.setString(2, password);
				ResultSet rs = pStmt.executeQuery();

				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String pass = rs.getString("password");
					ga = new GroupAccount(id, name, pass);
				 }
				rs.close();
				 pStmt.close();
				 conn.close();
		 	} catch (ClassNotFoundException e) {
	            e.printStackTrace();
			}catch(SQLException e) {
					 e.printStackTrace();
					 return null;
				 }
			 return ga;
		}

}

