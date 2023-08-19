package com.demo.bean;

public class LoginBean {
	String user,pass,role;

	public LoginBean() {
		super();
	}

	public LoginBean(String user, String pass, String role) {
		super();
		this.user = user;
		this.pass = pass;
		this.role = role;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginBean [user=" + user + ", pass=" + pass + ", role=" + role + "]";
	}
    
	
}
