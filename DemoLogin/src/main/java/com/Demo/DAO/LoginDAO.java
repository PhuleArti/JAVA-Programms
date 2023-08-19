package com.demo.DAO;

import java.sql.Connection;
import java.util.List;

import com.demo.bean.LoginBean;

public interface LoginDAO {
  LoginBean validateUser(String user,String pass);
  
  List<LoginBean> getAll(Connection conn);
}
