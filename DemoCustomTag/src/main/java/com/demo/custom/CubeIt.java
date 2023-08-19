package com.demo.custom;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CubeIt extends TagSupport {
 private int number;

  public void setNumber(int number) {
	this.number = number;
  }
   
  public int doStartingTag() {
	JspWriter out=pageContext.getOut();  
	 
	try {
		out.println(number*number*number);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return EVAL_BODY_INCLUDE;
	  
  }
}
