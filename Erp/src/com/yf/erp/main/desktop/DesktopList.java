package com.yf.erp.main.desktop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yf.erp.bean.Desktop;
import com.yf.erp.service.DesktopListService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
/**
 * @author 杨朗飞
 *   2016年11月7日  下午2:39:38
 *     获取岗位列表
 */
public class DesktopList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		PrintWriter writer=resp.getWriter();
		
		DesktopListService service=new DesktopListService();
		List<Desktop>  desktops=service.getDesktop();
		result=JsonUtil.getDesktopList(Contast.RESULT_SUCCESS_CODE,Contast.RESULT_SUCCESS_MSG,desktops);
		
		writer.print(result);
		writer.flush();
		writer.close();
	}

}
