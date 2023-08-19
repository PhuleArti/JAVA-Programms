package com.demo.service;

import com.demo.bean.LoginBean;

public interface LoginService {
	LoginBean ValidateUser(String user,String pass);
}
