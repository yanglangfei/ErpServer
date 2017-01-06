package com.yf.erp.base;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * @author ���ʷ�
 *2016��11��4��  ����4:11:47
 *
 *  ����web ����������
 */
public class WebListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent config) {
		//�ر�tomcat
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
		
		
		
		System.out.println("�ر� web");
	}

	@Override
	public void contextInitialized(ServletContextEvent config) {
		//��ʼ��tomcat
		System.out.println("����   web  ");
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
