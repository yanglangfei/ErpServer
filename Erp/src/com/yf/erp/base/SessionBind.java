package com.yf.erp.base;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author 杨朗飞
 *2016年11月4日  下午4:28:36
 *   session  把绑定参数   （一对一 ）
 */
public class SessionBind implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		//绑定session
		//https://github.com/yanglangfei/ErpServer
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		//解除session
		
	}


}
