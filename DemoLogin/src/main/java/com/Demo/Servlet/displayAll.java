package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.LoginBean;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class displayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public displayAll() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	
	
	
	
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    LoginService ls=new LoginServiceImpl();
	    List<LoginBean> list=ls.getAll();
	    response.setContentType("text/html");
	    
	    PrintWriter out= response.getWriter();
	    out.println("<h1>user details</h1>");
	    out.println("<table border = "+2+"><tr><td>Username</td><td> Role</td><td>Action</td></tr>);>");
	    for(LoginBean lb:list) {
	    	String edit="a href="+ ">edit</a>";
	    	String delete="<a href=\"Delete?username=\"";
	    	+lb.getuser+"\">Delete</a>";
	    	
	    }
	}

}
