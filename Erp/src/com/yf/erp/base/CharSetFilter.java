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
	private String encoding;
	@Override
	public void destroy() {
		//销毁
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		//对请求 返回参数进行编码设置
		req.setCharacterEncoding(encoding!=null ? encoding : "UTF-8");
		resp.setCharacterEncoding(encoding!=null ? encoding : "UTF-8");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filtConfig) throws ServletException {
		//初始化
		encoding=filtConfig.getInitParameter(encoding);
		
	}

}
