package com.yf.erp.main.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.erp.bean.Employee;
import com.yf.erp.service.EmployeeListService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;

public class EmployeeList extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String result;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer=resp.getWriter();
		EmployeeListService service=new EmployeeListService();
		List<Employee> list = service.getEmployee();
		result=JsonUtil.getEmlloyeeList(list,Contast.RESULT_SUCCESS_CODE,Contast.RESULT_SUCCESS_MSG);
	    writer.print(result);
	    writer.flush();
	    writer.close();
	}

}
