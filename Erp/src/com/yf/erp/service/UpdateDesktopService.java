package com.yf.erp.service;

import com.yf.erp.bean.Desktop;
import com.yf.erp.dao.DesktopDao;
public class UpdateDesktopService {
	
	public int updateDesktop(Desktop desktop){
		DesktopDao dao=new DesktopDao();
		return dao.updateDesktopInfo(desktop);
	}

}
