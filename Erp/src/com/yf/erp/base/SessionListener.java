package com.yf.erp.base;
import java.text.SimpleDateFormat;
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
	private int count;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//session  ����
		HttpSession session = se.getSession();
		session.setAttribute("count", count++);
		System.out.println("���û�����:"+session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// session ����
		HttpSession session = se.getSession();
		session.setAttribute("count", count--);
		System.out.println("�û�����:"+session.getId());
		
	}
}
