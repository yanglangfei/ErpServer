package com.yf.erp.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.erp.util.JsonUtil;

public class UpdateModel extends HttpServlet{
	private static final long serialVersionUID = -7233645173157416553L;
	private String result;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer=response.getWriter();
		result=JsonUtil.getModelData(0,"success");
		writer.print(result);
		writer.flush();
		writer.close();
	}
}
