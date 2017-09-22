package com.wealth.certificate.study_1z0_809.chapter29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInit {

	public static final String URL = "jdbc:derby:memory:question103;create=true";

	public static void init() {

		try (Connection conn = DriverManager.getConnection(URL)) {
			try (Statement stt = conn.createStatement()) {
				
				stt.execute("CREATE TABLE EMPLOYEE(ID INT PRIMARY KEY ,NAME VARCHAR(30), PHONENO VARCHAR(30)) ");
				stt.execute("INSERT INTO EMPLOYEE (ID,NAME,PHONENO) VALUES (111,'Michael','+919876543210')");
				stt.execute("INSERT INTO EMPLOYEE (ID,NAME,PHONENO) VALUES (112,'William','+449876543210')");
				stt.execute("INSERT INTO EMPLOYEE (ID,NAME,PHONENO) VALUES (113,'Trump','+99999543210')");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
