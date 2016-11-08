package com.yf.erp.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yf.erp.util.MD5Util;

/**
 * @author 杨朗飞
 *2016年11月8日  上午9:03:33
 *
 *     cookies     多个         服务器（生成）  -----> 客户端（存储  字符串）
 *     
 *     session        单个      会话   服务器(存储  对象)     <----- 客户端
 */
public class QuerryData extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ServletContext content;
	private List<Cookie> cookies=new ArrayList<Cookie>();
	private List<HttpSession> sessions=new ArrayList<HttpSession>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		content.setAttribute("session", sessions);
		content.setAttribute("cookies", cookies);
		String name=(String) request.getAttribute("name");
		String sex=request.getParameter("sex");
		HttpSession session = request.getSession();
		System.out.println("session:"+session.getId());
		String values = request.getRemoteAddr()+UUID.randomUUID();
		Cookie cookie=new Cookie("userName",values);
		Cookie pwdCookie=new Cookie("pwd", MD5Util.MD5("111111"));
		//设置  cookie保存时间 2分钟  
		//设置 负数时  浏览器内存中保存   关闭浏览器 销毁  
		//设置为0 立即销毁
		cookie.setMaxAge(60*2);
		
		pwdCookie.setMaxAge(60*2);
		//response.addCookie(cookie);
		//response.addCookie(pwdCookie);
		cookies.add(cookie);
		sessions.add(session);
		
		
		/*Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				System.out.println(cookies[i].getValue());
			}
		}else{
			System.out.println("不存在...");
		}*/
		
		PrintWriter writer=response.getWriter();
		
		writer.print("访问成功:"+request.getRemoteAddr());
		writer.flush();
		writer.close();
	}

	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		content = config.getServletContext();
	}
}
