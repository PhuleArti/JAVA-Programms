package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Calculate() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}
	
	public static int factorial(int num) {
		int fact=1;
		//String f="Factorial";
		for(int i=1;i<=num;i++) {
			fact=fact*i;
		}
		return fact;
	}
     public static String chkPrime(int num) {
        boolean flag=false;
        String str;
        //PrintWriter out = null;
        for(int i=2;i<=num/2;i++) {
        	if(num%i == 0) {
        		flag=true;
        		break;
        	}
        }
        if(!flag) { 
		str=(num+"is prime number");
        }
        else {
          str=(num+"is not prime number");
        }
        return str;
    	 
     }
     
     public static int SumOfDigit(int num) {
        int sum=0;int digit;
        for(int i=0;i<=num;i++) {
        	digit=num%10;
        	sum +=digit;
        	num=num/10;
        }
 		return sum;
 	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("Number"));
		String btn=request.getParameter("btn");
		PrintWriter out=response.getWriter();
		
		if(btn.equals(("fact"))) {
			int fact=Calculate.factorial(num);
			out.println(fact);
		}
		else if(btn.equals(("prime"))) {
			String str=Calculate.chkPrime(num);
			out.println(str);
		}
		else if(btn.equals(("SumDigit"))) {
			int sum=Calculate.SumOfDigit(num);
			out.println(sum);
		}
		
	}

}
