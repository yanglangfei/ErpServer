package com.yf.erp.base;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author 杨朗飞
 *2016年11月4日  下午4:23:07
 *  监听session属性值得变化
 */
public class SessioAttWatch implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//session 添加属性
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		//session 移除属性
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// session 替换属性
		
	}

}
