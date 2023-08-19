package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ArrayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ArrayServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {	
	}

	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       PrintWriter out=response.getWriter();
		        // create an array of integers
		       int size=Integer.parseInt(request.getParameter("Size"));
		        int[] numbers = {1, 2, 3, 4, 5};
		        
		        // loop through the array and output each element
		        for (int i = 0; i < numbers.length; i++) {
		            response.getWriter().println(numbers[i]);
		        }
		        for(int i=0;i<numbers.length;i++) {
		        	out.println("<h3>"+(numbers[i])+"</h3>");
		        }
		    }
	}

