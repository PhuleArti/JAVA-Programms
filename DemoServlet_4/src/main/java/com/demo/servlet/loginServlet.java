package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd;
		if(user.equals("seed") && pass.equals("seed"))
		{
			//out.println("<h1> Welcome to servlet"+user+"</h1>");
			rd=request.getRequestDispatcher("UserServlet");
			rd.forward(request, response);
		}
		else {
			out.println("<h1> invalid user</h1>");
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}

}
