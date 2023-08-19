package com.Demo.DAO_Data_Access_Object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Available");
			String url ="jdbc:oracle:thin:@DESKTOP-T1RPC3C:1521:XE";
			
			conn = DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connect sussess");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getCon(String driver, String url,String un, String pd) {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,un,pd);
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
