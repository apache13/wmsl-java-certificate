package com.wealth.certificate.dumps_1z0_809.question031;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	static Connection newConnection =null;
	public static Connection getDBConnection () throws SQLException {
		//try (Connection con = DriverManager.getConnection(URL, username, password)) {
		try (Connection con = DriverManager.getConnection(URL)) {
			newConnection = con;
		}
		return newConnection;
	}
	
	public static void main (String [] args) throws SQLException {
		Statement st = null;
		try {
			Connection conn = DriverManager.getConnection(URL);
			initialDatabase(conn);
			getDBConnection ();
			st = newConnection.createStatement();
			st.executeUpdate("INSERT INTO Student VALUES (102, 'Kelvin')");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final String URL = "jdbc:derby:memory:question031;create=true";

	public static void initialDatabase(Connection conn) {
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate("CREATE TABLE Student(ID INT PRIMARY KEY,NAME VARCHAR(8))");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

