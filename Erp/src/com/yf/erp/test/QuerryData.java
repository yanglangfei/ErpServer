package com.yf.erp.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yf.erp.util.MD5Util;

/**
 * @author ���ʷ�
 *2016��11��8��  ����9:03:33
 *
 *     cookies     ���         �����������ɣ�  -----> �ͻ��ˣ��洢  �ַ�����
 *     
 *     session        ����      �Ự   ������(�洢  ����)     <----- �ͻ���
 */
public class QuerryData extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ServletContext content;
	private List<Cookie> cookies=new ArrayList<Cookie>();
	private List<HttpSession> sessions=new ArrayList<HttpSession>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		content.setAttribute("session", sessions);
		content.setAttribute("cookies", cookies);
		String name=(String) request.getAttribute("name");
		String sex=request.getParameter("sex");
		HttpSession session = request.getSession();
		System.out.println("session:"+session.getId());
		String values = request.getRemoteAddr()+UUID.randomUUID();
		Cookie cookie=new Cookie("userName",values);
		Cookie pwdCookie=new Cookie("pwd", MD5Util.MD5("111111"));
		//����  cookie����ʱ�� 2����  
		//���� ����ʱ  ������ڴ��б���   �ر������ ����  
		//����Ϊ0 ��������
		cookie.setMaxAge(60*2);
		
		pwdCookie.setMaxAge(60*2);
		response.addCookie(cookie);
		response.addCookie(pwdCookie);
		cookies.add(cookie);
		sessions.add(session);
		
		
		/*Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				System.out.println(cookies[i].getValue());
			}
		}else{
			System.out.println("������...");
		}*/
		
		PrintWriter writer=response.getWriter();
		
		writer.print("���ʳɹ�:"+request.getRemoteAddr());
		writer.flush();
		writer.close();
	}

	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		content = config.getServletContext();
	}
}
