package com.yf.erp.base;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
/**
 * @author ���ʷ�
 *   2016��11��4��  ����4:10:21
 *    ��������
 */
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//��������
		HttpServletRequest req=(HttpServletRequest) arg0.getServletRequest();
		System.out.println("�û��������:"+req.getSession());
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// ��ʼ������
		HttpServletRequest req=(HttpServletRequest) arg0.getServletRequest();
		System.out.println("�û���������:"+req.getSession());
	}

}
