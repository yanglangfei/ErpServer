package com.yf.erp.service;

import java.util.List;

import com.yf.erp.bean.Employee;
import com.yf.erp.dao.EmployeeDao;

public class EmployeeListService {
	
	public List<Employee>   getEmployee(){
		EmployeeDao dao=new EmployeeDao();
		return dao.querryAll();
	}

}
