package com.yf.erp.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.yf.erp.main.model.Applicate;
import com.yf.erp.util.JsonUtil;

//   /tiqqian/updateApk
/**
 * @author 杨朗飞 更新apk
 */
public class UpdateApk extends HttpServlet {
	private String result;
	private String url;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Applicate app=getNewApkInfo();
		result = JsonUtil.getUpdateInfo(app);
		out.print(result);
		out.flush();
		out.close();
	}

	private Applicate getNewApkInfo() {
		Applicate app=new Applicate();
		app.setVersionCode(2);
		app.setVersionName("1.1");
		app.setContent("1.性能优化#2.网络优化");
		app.setMustUpdate(true);
		app.setUrl(url);
		return app;
	}

}
