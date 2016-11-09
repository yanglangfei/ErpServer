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
 * @author 杨朗飞
 *2016年11月4日  下午3:14:42
 *   过滤参数编码
 */
public class CharSetFilter implements Filter {

	private FilterConfig filtConfig;
	private String defaultEncode="UTF-8";

	@Override
	public void destroy() {
		//销毁
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		//获取初始化参数
		String encode=filtConfig.getInitParameter("encode");
		//对请求 返回参数进行编码设置
		req.setCharacterEncoding(encode!=null ? encode : defaultEncode);
		resp.setCharacterEncoding(encode!=null ? encode : defaultEncode);
		//处理get 请求乱码
		resp.setContentType("text/html;charset="+defaultEncode);
		req.setAttribute("name", "张三");
		System.out.println("设置编码");
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
		
		//放行访问  ---让请求继续进行
		chain.doFilter(request, response);
		
		//阻止访问   并将访问重定向到新的页面
		//resp.sendRedirect("http://www.baidu.com");
		
		/*
		PrintWriter writer=response.getWriter();
		writer.print("禁止访问!!");
		writer.flush();
		writer.close();*/
		
	}

	@Override
	public void init(FilterConfig filtConfig) throws ServletException {
		//初始化
		this.filtConfig=filtConfig;
		
	}

}
