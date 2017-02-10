package com.yf.erp.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		//2s刷新页面
		response.setIntHeader("Refresh", 2);
		PrintWriter out = response.getWriter();
		// 获取当前的时间
//		Calendar calendar = new GregorianCalendar();
//		String am_pm;
//		int hour = calendar.get(Calendar.HOUR);
//		int minute = calendar.get(Calendar.MINUTE);
//		int second = calendar.get(Calendar.SECOND);
//		if (calendar.get(Calendar.AM_PM) == 0)
//			am_pm = "AM";
//		else
//			am_pm = "PM";
//
//		String CT = hour + ":" + minute + ":" + second + " " + am_pm;
		Random random=new Random();
		int n = random.nextInt(100);

		out.print("llll...:" + n);
		out.flush();
		out.close();
	}

}
