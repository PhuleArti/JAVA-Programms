package com.demo.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport; 

public class HelloTag extends BodyTagSupport{

	public int doStartTag()throws JspException{
		JspWriter out= pageContext.getOut();
		try {
			out.println("inside doStarting");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("doStartTag");
		return EVAL_BODY_INCLUDE;
	}
}

