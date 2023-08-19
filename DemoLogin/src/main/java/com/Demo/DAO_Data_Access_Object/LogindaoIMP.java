package com.Demo.DAO_Data_Access_Object;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Demo.Bean.LoginBean;
import com.Demo.DAO_Data_Access_Object.DBUtil;

public class LogindaoIMP implements LoginDAO {
	Connection conn;
	
	@Override
	public LoginBean validateUser(String user, String pass) {
		// TODO Auto-generated method stub
		
		
		LoginBean l = null ;
		try {
			conn =  DBUtil.getConn();
			String query = "Select * from usersDB where username = ? and passwd = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				l = new LoginBean();
				l.setUser(rs.getString(1));
				l.setPass(rs.getString(2));
				l.setRole(rs.getString(3));
				//	System.out.println(rs.getString(1));
					//System.out.println(rs.getString(2)); 
					//System.out.println(rs.getString(3));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return l;
		
		
		
	}

	@Override
	public List<LoginBean> getAll(Connection con) {
		// TODO Auto-generated method stub
		List<LoginBean> l =null;
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from usersDB");
			l = new ArrayList<LoginBean>();
			while(rs.next()) {
				LoginBean lb = new LoginBean();
				lb.setUser(rs.getString(1));
				lb.setPass(rs.getString(2));
				lb.setRole(rs.getString(3));
				l.add(lb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
}
