package com.jack.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
private static Connection con ;
private static String drivername ="oracle.jdbc.driver.OracleDriver";
private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
private static String username="scott";
private static String password="tiger";

public static Connection getConnection() {
	try {
		Class.forName(drivername);
		con =DriverManager.getConnection(url, username, password);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
} 
}
