package com.demo.service;

import com.demo.DAO.LoginDAO;
import com.demo.DAO.LoginDAOimpl;
import com.demo.bean.LoginBean;

public class LoginServiceImpl implements LoginService {

	LoginDAO logindao=new LoginDAOimpl();
	public LoginServiceImpl() {
		
	}
	
	@Override
	public LoginBean ValidateUser(String user, String pass) {
		
		return logindao.validateUser(user, pass);
	}

}
