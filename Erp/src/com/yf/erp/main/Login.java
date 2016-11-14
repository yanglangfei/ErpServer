/**
 * 
 */
package com.yf.erp.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yf.erp.bean.User;
import com.yf.erp.service.LoginService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
import com.yf.erp.util.MD5Util;
/**
 * @author ���ʷ�
 *    2016��11��3��  ����9:54:15
 *    
 *    �û���¼
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
		HttpSession session = req.getSession();
		User user=LoginService.login(uName);
		if(user!=null){
			String wd=user.getPassword();
			if(wd.equals(MD5Util.MD5(pwd))){
				//��¼�ɹ�
				session.setAttribute("user", user);
				Cookie cookie=new Cookie("loginRes", uName+":"+pwd);
				cookie.setMaxAge(60*10);
				cookie.setPath(this.getServletContext().getContextPath());
				resp.addCookie(cookie);
				System.out.println("���õ�¼cookies");
				result=JsonUtil.getOpResult(Contast.RESULT_SUCCESS_CODE,Contast.RESULT_SUCCESSLOGIN_MSG);
			}else{
				//��¼ʧ��
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
