package com.demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.LoginBean;

public class LoginDAOimpl implements LoginDAO {
    
	Connection conn;
	public LoginDAOimpl() {
		
	}
	@Override
	public LoginBean validateUser(String user, String pass) {
		LoginBean l=null;
		
		conn=DButil.getConnection();
		System.out.println("connect successfully");
		String query="select * from userDB where username=? and Password=?";
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			conn.prepareStatement(query);
			stmt.setString(1,user);
			stmt.setString(2,pass);
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {//moves record to first position
				l=new LoginBean();
				l.setUsername(rs.getString(1));
				l.setPassword(rs.getString(2));
				l.setRole(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
		
		
	}
	@Override
	public List<LoginBean> getAll(Connection conn) {
		
		List<LoginBean> l=null;
		
		try {
			Statement st =conn.createStatement();
			ResultSet rs= st.executeQuery("select * from userDB");
			l=new ArrayList<LoginBean>();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
