package com.yf.erp.service;

import com.yf.erp.dao.DesktopDao;
public class DelDesktopService {
	public int delDesktop(int id){
		DesktopDao dao=new DesktopDao();
		return dao.delDesktop(id);
	}

}
