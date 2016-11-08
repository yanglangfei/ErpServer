package com.yf.erp.service;
import com.yf.erp.dao.PositionDao;

public class DelPositionService {
	
	public int delPosition(int id){
		PositionDao dao=new PositionDao();
		return dao.delPosition(id);
	}

}
