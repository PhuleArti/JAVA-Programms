package com.demo.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	
	public static Connection getConnection() {//return type of connection should be connection
		Connection conn = null;
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userDB", "root", "ARTI@123root");
		 } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}


  public static Connection getConnection(String driver,String url,String user,String pass) {
	  Connection conn=null;
	  
	  try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, pass);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return conn;
	
 }
}













