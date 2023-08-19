package com.demo.dao;

import com.demo.bean.LoginBean;

public interface LoginDao {
	 LoginBean ValidateUser(String user,String pass) ;
}
