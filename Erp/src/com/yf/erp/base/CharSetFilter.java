package com.yf.erp.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String uri = req.getRequestURI();
		if(uri.equals("login")){
			//��ֹ����   ���������ض����µ�ҳ��
			resp.sendRedirect("http://192.168.1.134:8080/Erp/login");
		}else{
			chain.doFilter(req,resp);
		}
	}

	@Override
	public void init(FilterConfig filtConfig) throws ServletException {
		//��ʼ��
		this.filtConfig=filtConfig;
		
	}

}
