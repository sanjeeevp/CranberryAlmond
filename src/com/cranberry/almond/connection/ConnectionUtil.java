package com.cranberry.almond.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {

	public static Connection conn = null;
	
	public static Connection openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://localhost:3306/Employee";
			String connectionUser = "root";
			String connectionPassword = "root";

			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connection open");
		return conn;
	}
	
	public static void closeConnection(PreparedStatement ps, Connection conn, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection closed");
	}
}
