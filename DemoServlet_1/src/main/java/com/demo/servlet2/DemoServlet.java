package com.demo.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DemoServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   int num=Integer.parseInt(request.getParameter("Number"));
	   PrintWriter out=response.getWriter();
	   for(int i=1;i<11;i++) {
		   out.println("<h3>"+(i*num)+"</h3>");
	   }
	}

}
