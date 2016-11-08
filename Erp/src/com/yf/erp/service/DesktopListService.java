package com.yf.erp.service;

import java.util.List;

import com.yf.erp.bean.Desktop;
import com.yf.erp.dao.DesktopDao;
public class DesktopListService {
	
	public List<Desktop>   getDesktop(){
		DesktopDao dao=new DesktopDao();
		return dao.querryDesktopList();
	}

}
