package com.yf.erp.base;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author ���ʷ�
 *2016��11��4��  ����4:23:07
 *  ����session����ֵ�ñ仯
 */
public class SessioAttWatch implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//session �������
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		//session �Ƴ�����
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// session �滻����
		
	}

}
