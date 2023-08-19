package com.Demo.DAO_Data_Access_Object;

import java.sql.Connection;
import java.util.List;

import com.Demo.Bean.LoginBean;

public interface LoginDAO {
	LoginBean validateUser(String user, String pass);
	List<LoginBean> getAll(Connection con);
}
