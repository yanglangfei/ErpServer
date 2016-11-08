package com.yf.erp.service;

import com.yf.erp.bean.Position;
import com.yf.erp.dao.PositionDao;

public class AddPositionService {
	
	public int addPosition(Position position){
		PositionDao dao=new PositionDao();
		return dao.addPosition(position);
	}

}
