package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddIt extends HttpServlet{
	
   public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int sum=Integer.parseInt(request.getParameter("num1"))
    		+Integer.parseInt(request.getParameter("num2"));
    
    PrintWriter out=response.getWriter();
    out.println(sum);
 }
}