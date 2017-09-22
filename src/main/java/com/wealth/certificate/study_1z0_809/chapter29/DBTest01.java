package com.wealth.certificate.study_1z0_809.chapter29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest01 {
	public static void main(String[] args) {

		String user = null;
		String passw = null;
		DBInit.init();
		try (Connection con = DriverManager.getConnection(DBInit.URL, user, passw);
				Statement stmt = con.createStatement();
//				 Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_
//				            SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			) {
			
			boolean hasResults = stmt.execute("SELECT * FROM employee");
			System.out.println("execute -> SELECT::"+hasResults);
			if (hasResults) {
				// To retrieve the object with the results
				ResultSet rs = stmt.getResultSet();
				System.out.println("ID \tNAME \tPHONENO");
				while (rs.next()) {
					System.out.println(rs.getInt("id") + "\t"
					        + rs.getString("NAME") + "\t"
					        + rs.getString("PHONENO"));
				}
			} else {
				// To get the number of affected rows
				int affectedRows = stmt.getUpdateCount();
			}
			System.out.println("--------After update---------");
			
			int result1 = stmt.executeUpdate("INSERT INTO EMPLOYEE (ID,NAME,PHONENO) VALUES (114,'George','+999000043210')"); // Returns 1
			int result2 = stmt.executeUpdate("UPDATE EMPLOYEE SET NAME='Joe' " + "WHERE id = 111"); // Returns 1
			int result3 = stmt.executeUpdate("DELETE FROM EMPLOYEE " + "WHERE id = 112"); // Returns 1
			System.out.println("executeUpdate -> INSERT::"+result1+" UPDATE::"+result2+" DELETE::"+result3);
			
			System.out.println("executeQuery -> ResulSet");
			System.out.println("(1)");
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			System.out.println("ID \tNAME \tPHONENO");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t"
				        + rs.getString("NAME") + "\t"
				        + rs.getString("PHONENO"));
			}
			
			System.out.println("---------------------------------------");
			System.out.println("(2)");
			
//			rs.beforeFirst();
			rs = stmt.executeQuery("SELECT * FROM employee");
			System.out.println("ID \tNAME \tPHONENO");
			int numOfColumns = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for(int i = 1; i <= numOfColumns; i++) {
					System.out.print(rs.getObject(i) + "\t");
				}
				System.out.println("");
			}
			
//		    rs.absolute(1);
//            rs.updateString("phoneNo", "+919976543210");
             
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
