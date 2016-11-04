package com.yf.erp.base;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author ���ʷ�
 *2016��11��4��  ����4:08:35
 *
 *   ����session�Ự
 *
 */
public class SessionListener implements HttpSessionListener {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//session  ����
		HttpSession session = se.getSession();
		System.out.println("create:"+sdf.format(new Date(session.getCreationTime()))+"   "+session.getId());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// session ����
		HttpSession session = se.getSession();
		System.out.println("destory:"+sdf.format(new Date(session.getCreationTime()))+"   "+session.getId());
	}

}
