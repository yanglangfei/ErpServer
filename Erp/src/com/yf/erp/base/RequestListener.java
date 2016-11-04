package com.yf.erp.base;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author 杨朗飞
 *2016年11月4日  下午4:10:21
 *
 *  监听请求
 */
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//销毁请求
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// 初始化请求
		
	}

}
