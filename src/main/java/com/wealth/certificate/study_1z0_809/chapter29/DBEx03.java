package com.wealth.certificate.study_1z0_809.chapter29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBEx03 {
	public static void main(String[] args) {

		String user = null;
		String passw = null;
		DBInit.init();
		try (Connection con = DriverManager.getConnection(DBInit.URL, user, passw);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			) {
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			System.out.println("ID \tNAME \tPHONENO");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t"
				        + rs.getString("NAME") + "\t"
				        + rs.getString("PHONENO"));
			}
			
			System.out.println("-----------------");
			
			ResultSet rs2 = stmt.executeQuery("SELECT * FROM employee Where id = 113"); // ResultSet rs is automatically closed 
			System.out.println("ID \tNAME \tPHONENO");
			int numOfColumns = rs2.getMetaData().getColumnCount();
			while (rs2.next()) {
				for(int i = 1; i <= numOfColumns; i++) {
					System.out.print(rs2.getObject(i) + "\t");
				}
				System.out.println("");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
