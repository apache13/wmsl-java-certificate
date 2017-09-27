package com.wealth.certificate.study_1z0_809.chapter29.selftest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM user")) {
			while (rs.next()) {
				System.out.println(rs.getObject(1));
			}
		} catch (SQLException e) {
			System.out.println("SQLException");
		}
	}
}

// 1.The correct answer is B.
// If the result set is empty, next() returns false, so nothing is printed.