package com.wealth.certificate.dumps_1z0_809_ps.question027;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	static Connection newConnection =null;
	
	public static Connection getDBConnection () throws SQLException { 
		String url = "jdbc:sqlserver://phonlawat:1433;DatabaseName=master";
		String username = "user", password = "password";
		try (Connection con = DriverManager.getConnection(url, username, password)) // closed before use
		{
			newConnection = con;
		}
		return newConnection;
	}
	
	public static void main (String [] args) throws SQLException {
		getDBConnection ();
		Statement st = newConnection.createStatement(); // runtime error cause connection is closed
		st.executeUpdate("INSERT INTO student VALUES (102, `Kelvin')");
	}
}