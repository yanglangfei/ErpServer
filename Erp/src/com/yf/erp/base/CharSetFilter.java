package com.yf.erp.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yf.erp.bean.User;

/**
 * @author ���ʷ�
 *2016��11��4��  ����3:14:42
 *   ���˲�������
 */
public class CharSetFilter implements Filter {

	private FilterConfig filtConfig;
	private String defaultEncode="UTF-8";

	@Override
	public void destroy() {
		//����
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		//��ȡ��ʼ������
		String encode=filtConfig.getInitParameter("encode");
		//������ ���ز������б�������
		req.setCharacterEncoding(encode!=null ? encode : defaultEncode);
		resp.setCharacterEncoding(encode!=null ? encode : defaultEncode);
		//����get ��������
		resp.setContentType("text/html;charset="+defaultEncode);
		req.setAttribute("name", "����");
		/*Cookie[] cookies=req.getCookies();
		HttpSession session = req.getSession();
		if(cookies!=null){
			for (Cookie cook : cookies){
				System.out.println("cook:"+cook.getName());
			}
		}else{
			System.out.println("no cook");
		}
		System.out.println("session:"+session.getId());*/
		
		//���з���  ---�������������
		chain.doFilter(request, response);
		
		//��ֹ����   ���������ض����µ�ҳ��
		//resp.sendRedirect("http://www.baidu.com");
		
		/*
		PrintWriter writer=response.getWriter();
		writer.print("��ֹ����!!");
		writer.flush();
		writer.close();*/
		
	}

	@Override
	public void init(FilterConfig filtConfig) throws ServletException {
		//��ʼ��
		this.filtConfig=filtConfig;
		
	}

}
