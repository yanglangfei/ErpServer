/**
 * 
 */
package com.yf.erp.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.erp.bean.User;
import com.yf.erp.service.LoginService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
import com.yf.erp.util.MD5Util;

/**
 * @author 杨朗飞
 *    2016年11月3日  上午9:54:15
 *    
 *    用户登录
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  this.doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer=resp.getWriter();
		String uName = req.getParameter("userName");
		String pwd=req.getParameter("password");
		User user=LoginService.login(uName);
		if(user!=null){
			String wd=user.getPassword();
			if(wd.equals(MD5Util.MD5(pwd))){
				result=JsonUtil.getOpResult(Contast.RESULT_SUCCESS_CODE,Contast.RESULT_SUCCESSLOGIN_MSG);
			}else{
				result=JsonUtil.getOpResult(Contast.RESULT_FAIL_ERRPWD,Contast.RESULT_FAIL_ERRPWD_MSG);
			}
		}else{
			result=JsonUtil.getOpResult(Contast.RESULT_FAIL_EXIST,Contast.RESULT_FAIL_EXIST_MSG);
		}
		writer.print(result);
		writer.flush();
		writer.close();
	}

}
