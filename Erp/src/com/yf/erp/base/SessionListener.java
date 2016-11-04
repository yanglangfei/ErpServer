package com.yf.erp.base;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 杨朗飞
 *2016年11月4日  下午4:08:35
 *
 *   监听session会话
 *
 */
public class SessionListener implements HttpSessionListener {


	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//session  创建
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// session 销毁
		
	}

}
