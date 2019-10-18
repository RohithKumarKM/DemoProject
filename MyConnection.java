package com.mphasis.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection 
{
	public static Connection getConnection() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	//Create Connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "12345");
		System.out.println("Connection Successful");
		return con;
	}
}
