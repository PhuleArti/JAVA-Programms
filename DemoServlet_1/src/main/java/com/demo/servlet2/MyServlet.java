package com.demo.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside inti");
	}

	
	public void destroy() {
		System.out.println("inside destroy");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		PrintWriter out=response.getWriter();
		if(name.equals("seed") && pass.equals("seed"))
		{
			out.println("<h1> Welcome to servlet"+name+"</h1>");
		}
		else {
			out.println("<h1> invalid user</h1>");
		}
	}

}
