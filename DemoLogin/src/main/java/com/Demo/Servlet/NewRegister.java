package com.Demo.Servlet;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Demo.DAO_Data_Access_Object.DBUtil;

/**
 * Servlet implementation class NewRegister
 */
public class NewRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password  = request.getParameter("passw");
		String radiouse = request.getParameter("use");
		String btn = request.getParameter("btn");
		
		Connection conn = DBUtil.getConn();
		
		if(btn.equals("Register")) {
			try {
				
				String query = "insert into usersDB values (?,?,?) ";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.executeQuery(query);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, radiouse);
				ps.executeUpdate();
				
				 
				System.out.println("Reg succ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	

}
