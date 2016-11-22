package com.yf.erp.base;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
/**
 * @author 杨朗飞
 *   2016年11月4日  下午4:10:21
 *    监听请求
 */
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//销毁请求
		HttpServletRequest req=(HttpServletRequest) arg0.getServletRequest();
		System.out.println("用户请求结束:"+req.getSession());
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// 初始化请求
		HttpServletRequest req=(HttpServletRequest) arg0.getServletRequest();
		System.out.println("用户发出请求:"+req.getSession());
	}

}
