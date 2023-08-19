package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.LoginBean;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		
		LoginService ls =new LoginServiceImpl();
		LoginBean l=ls.ValidateUser(user, pass);
		RequestDispatcher rd;
		
		if(l !=null) {
			   if(l.getRole().equals("user")) {
			   rd=request.getRequestDispatcher("UserServlet");
				rd.forward(request,response);
			  }
			  else if(l.getRole().equals("admin")) {
			 rd=request.getRequestDispatcher("AdminServlet");
				rd.forward(request,response);
			  }
		    }
			else 
			{
				out.println("<br><h2 style=\"color:red\">invalid user"+"</h2>");
			    rd=request.getRequestDispatcher("login.html");
			    rd.include(request,response);
			}
		}
	}

