package com.yf.erp.service;

import com.yf.erp.bean.User;
import com.yf.erp.dao.UserDao;

public class LoginService {
	
	public static User login(String userName){
		UserDao dao=new UserDao();
		return dao.queryUserByName(userName);
	}

}
