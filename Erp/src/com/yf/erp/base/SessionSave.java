package com.yf.erp.base;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author 杨朗飞 2016年11月4日 下午4:13:08
 * 
 *         session 的钝化（关闭web容器时保存到文件） 和 活化 (开启web容器加载到项目)
 */
public class SessionSave implements HttpSessionActivationListener {

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// 活化
		//System.out.println("sessionDidActivate...");

	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// 钝化
		//System.out.println("sessionWillPassivate...");

	}

}
