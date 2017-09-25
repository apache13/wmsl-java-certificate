package com.wealth.certificate.study_1z0_809.chapter29.selftest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test04 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost");
				Statement stmt = con.createStatement()) {
			System.out.println(stmt.execute("INSERT INTO user VALUES(1,'Joe')"));
		} catch (SQLException e) {
			/** ... */
		}
	}

}
// 4. The correct answer is B.
// execute() returns a boolean value, true for SELECT and false for other
// statements.