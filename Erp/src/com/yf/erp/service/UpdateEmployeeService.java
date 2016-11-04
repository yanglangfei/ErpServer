package com.yf.erp.service;

import com.yf.erp.bean.Employee;
import com.yf.erp.dao.EmployeeDao;

public class UpdateEmployeeService {
	
	public int updateEmployee(Employee employee){
		EmployeeDao dao=new EmployeeDao();
		return dao.updateEmployee(employee);
	}

}
