package com.yf.erp.main;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yf.erp.service.DelEmployeeService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
import com.yf.erp.util.StringUtil;

public class DelEmployee extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String result;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer=resp.getWriter();
		String id = req.getParameter("id");
		if(StringUtil.isInteger(id)){
			int index=Integer.parseInt(id);
			DelEmployeeService service=new DelEmployeeService();
			int res=service.delEmployee(index);
			result=res>0 ?
					JsonUtil.getOpResult(Contast.RESULT_SUCCESS_CODE, Contast.RESULT_SUCCESS_MSG)
					:
						JsonUtil.getOpResult(Contast.RESULT_FAIL_CODE, Contast.RESULT_FAIL_MSG);
		}
		writer.print(result);
		writer.flush();
		writer.close();
		
	}

}
