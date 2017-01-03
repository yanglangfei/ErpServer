package com.yf.erp.base;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
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
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int count;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//session  创建
		HttpSession session = se.getSession();
		session.setAttribute("count", count++);
		System.out.println("新用户上线:"+session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// session 销毁
		HttpSession session = se.getSession();
		session.setAttribute("count", count--);
		System.out.println("用户下线:"+session.getId());
		
	}
}
