package com.yf.erp.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.erp.bean.User;


public class AutoLogin implements Filter{

	@Override
	public void destroy() {
		System.out.println("destroy()��"+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String value = null;
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String uri = req.getRequestURI();
		if(uri.contains("login")){
			//��ǰ�ڵ�¼����  ֱ�ӷ���  
			System.out.println("��ǰ�ڵ�¼���棬ֱ�ӷ���");
			chain.doFilter(req, resp);
		}else{
			User user=(User) req.getSession().getAttribute("user");
			if(user!=null){
				String userName=user.getUserName();
				String password=user.getPassword();
				System.out.println("�Ѿ���¼:"+userName+"  pwd:"+password);
				chain.doFilter(req, resp);
				System.out.println("�Ѿ���¼:���");
			}else{
				Cookie[] cookies = req.getCookies();
				if(cookies!=null){
					for(int i=0;i<cookies.length;i++){
						if(cookies[i]!=null&&cookies[i].getName().equals("loginRes")){
							value = cookies[i].getValue();
							break;
						}
					}
					if(value!=null){
						//�Զ���¼
						String userName = value.split(":")[0];
						String password=value.split(":")[1];
						user=new User();
						user.setPassword(password);
						user.setUserName(userName);
						req.getSession().setAttribute("user", user);
						System.out.println("�Զ���¼...   :  ��¼cookie:"+value);
						//����֮ǰ�Ĳ���
						chain.doFilter(req, resp);
						//����֮��Ĳ���
						System.out.println("�Զ���¼�ɹ�");
					}else{
						//��¼ʧ��    ���ص�¼����
						System.out.println("�����¼����");
						resp.sendRedirect("http://127.0.0.1:8020/ERP/index.html");
					//	req.getRequestDispatcher("http://127.0.0.1:8020/ERP/index.html").forward(req, resp);
					}
				}else{
					//cookies ������  ���µ�¼
					System.out.println("�����¼����");
					resp.sendRedirect("http://127.0.0.1:8020/ERP/index.html");
					//req.getRequestDispatcher("http://127.0.0.1:8020/ERP/index.html").forward(req, resp);
				}
				
			}
			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("init��"+Thread.currentThread().getStackTrace()[1].getMethodName());
		filterConfig.getServletContext().getAttribute("USERMANAGER");
		
	}

	

}
