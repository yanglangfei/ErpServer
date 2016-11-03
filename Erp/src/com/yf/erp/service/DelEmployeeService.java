package com.yf.erp.service;

import com.yf.erp.dao.EmployeeDao;
public class DelEmployeeService {
	
	public int delEmployee(int id){
		EmployeeDao dao=new EmployeeDao();
		return dao.delEmployee(id);
	}

}
