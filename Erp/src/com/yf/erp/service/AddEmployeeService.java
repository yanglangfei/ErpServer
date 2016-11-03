package com.yf.erp.service;

import com.yf.erp.bean.Employee;
import com.yf.erp.dao.EmployeeDao;

public class AddEmployeeService {
	
	public int addEmployee(Employee employee){
		EmployeeDao dao=new EmployeeDao();
		return dao.addEmployee(employee);
	}

}
