package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.bean.LoginBean;

public class LoginDaoImpl implements LoginDao {

	Connection conn=null;
	public LoginBean ValidateUser(String user, String pass) {
		LoginBean l=null;
		
		conn=DButil.getConnection();
		System.out.println("connect successfully");
		String query="select * from userDB where username=? and password=?";
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			conn.prepareStatement(query);
			stmt.setString(1,user);
			stmt.setString(2,pass);
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {//moves record to first position
				l=new LoginBean();
				l.setUser(rs.getString(1));
				l.setPass(rs.getString(2));
				l.setRole(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

		
	}

