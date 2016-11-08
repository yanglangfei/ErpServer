package com.yf.erp.main.position;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.erp.service.DelPositionService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
import com.yf.erp.util.StringUtil;

/**
 * @author 杨朗飞
 *2016年11月7日  下午4:18:20
 *
 *  删除岗位信息
 */
public class DelPosition extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String result ;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer=resp.getWriter();
		String id=req.getParameter("id");
		
		DelPositionService service=new DelPositionService();
		int res=service.delPosition(StringUtil.isNotNull(id)&&StringUtil.isInteger(id) ? Integer.parseInt(id) : 0);		 result =res>0 ?JsonUtil.getEmlloyeeList(null, Contast.RESULT_SUCCESS_CODE, Contast.RESULT_SUCCESS_MSG)
					:
						JsonUtil.getEmlloyeeList(null, Contast.RESULT_FAIL_CODE, Contast.RESULT_FAIL_MSG)
					;	      
	     writer.print(result);
	     writer.flush();
	     writer.close();
	}

}
