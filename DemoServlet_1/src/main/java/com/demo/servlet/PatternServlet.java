package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatternServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside init");
	}
	public void destroy() {
	   System.out.println("inside destroy");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int Row=Integer.parseInt(request.getParameter("rows"));
		int Col=Integer.parseInt(request.getParameter("columns"));
		for(int i=1;i<=Row;i++) {
			for(int j=1;j<=i;j++) {
				out.print("* ");
			}
			out.println("<br>");
		}
		for(int i=1;i<=Row;i++) {
			for(int j=1;j<=i;j++) {
				out.print("*"+" "+"#");
			}
			out.println("<br>");
		}
		for(int i=1;i<=Row;i++) {
			for(int j=1;j<=Col;j++) {
				if(j%2==0)
				   out.print("$");
				else
					out.print("%");
			}
			out.println("<br>");
		}
	}

}
