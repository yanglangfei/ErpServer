package com.yf.erp.base;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author ���ʷ� 2016��11��4�� ����4:13:08
 * 
 *         session �Ķۻ����ر�web����ʱ���浽�ļ��� �� � (����web�������ص���Ŀ)
 */
public class SessionSave implements HttpSessionActivationListener {

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// �
		//System.out.println("sessionDidActivate...");

	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// �ۻ�
		//System.out.println("sessionWillPassivate...");

	}

}
