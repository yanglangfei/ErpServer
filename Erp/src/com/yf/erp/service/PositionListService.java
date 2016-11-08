package com.yf.erp.service;

import java.util.List;

import com.yf.erp.bean.Position;
import com.yf.erp.dao.PositionDao;

public class PositionListService {
	
	public List<Position> querryPosition(){
		PositionDao dao=new PositionDao();
		return dao.querryPositionList();
	}

}
