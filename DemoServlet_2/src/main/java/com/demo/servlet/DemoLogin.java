package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoLogin extends HttpServlet{
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String user=request.getParameter("username");
	String pass=request.getParameter("password");
    PrintWriter out=response.getWriter();
    if(user.equals("seed") && pass.equals("seed")) {
    	out.println("<h1>"+"welcome"+"</h1>");
    }
    else {
    	out.println("<h1>"+"invalid user"+"</h1>");
    }
}
}
