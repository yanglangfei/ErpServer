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
import javax.servlet.http.HttpSession;
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		//TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		if(session==null || session.getAttribute("user")==null){
			//Î´µÇÂ¼
			req.getRequestDispatcher("/admin/login.html").forward(req, resp);
			
		}else{
			resp.setContentType("text/html;charset=UTF-8");
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
