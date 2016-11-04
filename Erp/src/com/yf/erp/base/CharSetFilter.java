package com.yf.erp.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ���ʷ�
 *2016��11��4��  ����3:14:42
 *   ���˲�������
 */
public class CharSetFilter implements Filter {

	private FilterConfig filtConfig;

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
		req.setCharacterEncoding(encode);
		resp.setCharacterEncoding(encode);
		req.setAttribute("name", "����");
		//���з���  ---�������������
		//chain.doFilter(request, response);
		
		//��ֹ����   ���������ض����µ�ҳ��
		//resp.sendRedirect("http://www.baidu.com");
		
		
		PrintWriter writer=response.getWriter();
		writer.print("��ֹ����!!");
		writer.flush();
		writer.close();
		
	}

	@Override
	public void init(FilterConfig filtConfig) throws ServletException {
		//��ʼ��
		this.filtConfig=filtConfig;
		
	}

}
