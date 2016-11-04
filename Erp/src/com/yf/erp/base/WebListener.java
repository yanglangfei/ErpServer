package com.yf.erp.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 杨朗飞
 *2016年11月4日  下午4:11:47
 *
 *  监听web 容器的启动
 */
public class WebListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//关闭tomcat
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//初始化tomcat
		
	}

}
