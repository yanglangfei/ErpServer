package com.yf.erp.base;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * @author 杨朗飞
 *2016年11月4日  下午4:11:47
 *
 *  监听web 容器的启动
 */
public class WebListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent config) {
		//关闭tomcat
		ServletContext content = config.getServletContext();
		List<HttpSession> sessions=(List<HttpSession>) content.getAttribute("session");
		List<Cookie>  cookies=(List<Cookie>) content.getAttribute("cookies");
		if(sessions!=null){
			for(HttpSession session : sessions){
				System.out.println("seesion:"+session.getId());
			}
		}else{
			System.out.println("no session");
		}
		
		if(cookies!=null){
			for(Cookie cookie : cookies){
				System.out.println("cookies:"+cookie.getName()+"  "+cookie.getValue()+"   "+cookie.getSecure()+"   "+cookie.getDomain());
			}
		}else{
			System.out.println("no cookies");
		}
		
		
		
		System.out.println("关闭 web");
	}

	@Override
	public void contextInitialized(ServletContextEvent config) {
		//初始化tomcat
		System.out.println("启动   web  ");
	}
	
	
	public static void main(String[] args) {
		int num=new Exception().getStackTrace()[0].getLineNumber();
		String cm=new Exception().getStackTrace()[0].getClassName();
		String mm=new Exception().getStackTrace()[0].getMethodName();
		String fm=new Exception().getStackTrace()[0].getFileName();
		//int num=Thread.currentThread().getStackTrace()[0].getLineNumber();
		System.out.println("num:"+num+" cm:"+cm+"  mm:"+mm+"  fm:"+fm);
	}

}
