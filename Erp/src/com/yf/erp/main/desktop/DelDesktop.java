package com.yf.erp.main.desktop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yf.erp.service.DelDesktopService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
import com.yf.erp.util.StringUtil;

/**
 * @author ���ʷ�
 *2016��11��7��  ����3:09:13
 *  ɾ��   ������Ϣ
 */
public class DelDesktop extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String result;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer=resp.getWriter();
		String id=req.getParameter("id");
		
		DelDesktopService service=new DelDesktopService();
		int res=service.delDesktop(StringUtil.isNotNull(id)&&StringUtil.isInteger(id) ?  Integer.parseInt(id) :0);
		 result=res>0 ?JsonUtil.getEmlloyeeList(null, Contast.RESULT_SUCCESS_CODE, Contast.RESULT_SUCCESS_MSG)
					:
						JsonUtil.getEmlloyeeList(null, Contast.RESULT_FAIL_CODE, Contast.RESULT_FAIL_MSG)
					;
		 
		 writer.print(result);
		 writer.flush();
		 writer.close();
	}

}
