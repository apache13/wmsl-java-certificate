package com.wealth.certificate.study_1z0_809.chapter29;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.wealth.certificate.dumps_1z0_809.question103.DBInitializer;

public class DBEx02 {
	static Connection newConnection = null;
	public static final String URL = "jdbc:derby:memory:chapter29;create=true";

	public static void main(String[] args) throws SQLException {
		DBInit.init();
		String dbURL = DBInit.URL, userName = null, passWord = null;

		Connection conn = DriverManager.getConnection(dbURL, userName, passWord);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		boolean hasResults = stmt.execute("SELECT * FROM employee");
		if (hasResults) {
			System.out.println("have data");
		} else {
			System.out.println("don't have data");
		}

		int result1 = stmt.executeUpdate("INSERT INTO EMPLOYEE (ID,NAME,PHONENO) VALUES (114,'George','+999000043210')"); // Returns 1																					// 1
		int result2 = stmt.executeUpdate("UPDATE EMPLOYEE SET NAME='Joe' " + "WHERE id = 111"); // Returns 1
		int result3 = stmt.executeUpdate("DELETE FROM EMPLOYEE " + "WHERE id = 112"); // Returns 1
		System.out.println("executeUpdate -> INSERT::" + result1 + " UPDATE::" + result2 + " DELETE::" + result3);

		ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
		System.out.println("ID \tNAME \tPHONENO");
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "\t" + rs.getString("NAME") + "\t" + rs.getString("PHONENO"));
		}
		System.out.println("--------After update---------");
		rs.beforeFirst();
		while (rs.next()) {
			if (rs.getInt(1) == 112) {
				rs.updateString(2, "Jack");
			}
			System.out.println(rs.getInt("id") + "\t" + rs.getString("NAME") + "\t" + rs.getString("PHONENO"));

		}
		rs.absolute(2);
		System.out.println("result: -->" + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString("PHONENO"));
	}

}
