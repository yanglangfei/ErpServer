package com.yf.erp.service;

import com.yf.erp.bean.Desktop;
import com.yf.erp.dao.DesktopDao;
public class AddDesktopService {
	
	public int addDesktop(Desktop desktop){
		DesktopDao dao=new DesktopDao();
		return dao.addDesktop(desktop);
	}

}
