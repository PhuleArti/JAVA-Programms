package com.demo.bean;

public class LoginBean {
		   String username,password;

		public LoginBean() {
			super();
		}

		public LoginBean(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "LoginBean [username=" + username + ", password=" + password + "]";
		}
		
		public boolean validate() {
			if(username.equals("seed") && password.equals("seed")) {
			return true;
			}
			return false;
			
		}
	
}
