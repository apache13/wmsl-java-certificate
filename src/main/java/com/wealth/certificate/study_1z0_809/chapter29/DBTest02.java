package com.wealth.certificate.study_1z0_809.chapter29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest02 {
	static Connection newConnection =null;
	public static final String URL = "jdbc:derby:memory:chapter29;create=true";

	public static void main(String[] args) throws SQLException {

		// Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		// Statement stmt = conn.createStatement();
		// int result = stmt.executeUpdate("update animal set name = name");
		// System.out.println(result);

		// Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
		// Statement stmt = conn.createStatement();
		// int result = stmt.executeUpdate("update food set amount = amount + 1");
		// System.out.println(result);

		try (Connection conn = DriverManager.getConnection(URL); 
				Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("select count(*) from species");
			int num = stmt.executeUpdate("INSERT INTO species VALUES (3, 'Ant', .05)");
			rs.next();
			System.out.println(rs.getInt(1));
		}

	}

}
