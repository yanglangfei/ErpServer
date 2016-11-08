package com.yf.erp.service;

import com.yf.erp.bean.Position;
import com.yf.erp.dao.PositionDao;

public class UpdatePositionService {
	
	public int updatePosition(Position position){
		PositionDao dao=new PositionDao();
		return dao.updatePosition(position);
	}

}
