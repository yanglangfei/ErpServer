package com.yf.erp.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

//   /tiqqian/updateApk
public class UpdateApk extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/*{
			  "versionCode":1,
			  "versionName":"1.0.0",
			  "content":"1.������������#2.�����Ż�",//use # to wrap
			  "mustUpdate":true,    //must update ,true or false
			  "url":"apk download url"
			}*/
		
		JsonObject object=new JsonObject();
		object.addProperty("versionCode", 2);
		object.addProperty("versionName", "1.2");
		object.addProperty("content", "1.������������#2.�����Ż�#3.����ģ��");
		object.addProperty("mustUpdate", false);
		object.addProperty("url", "http://192.168.1.134:8080/Erp/����.apk");
		out.print(object.toString());
		out.flush();
		out.close();
	}

}
