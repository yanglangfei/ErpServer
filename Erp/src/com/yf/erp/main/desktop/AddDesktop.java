/**
 * 
 */
package com.yf.erp.main.desktop;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yf.erp.bean.Desktop;
import com.yf.erp.service.AddDesktopService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
import com.yf.erp.util.StringUtil;

/**
 * @author 杨朗飞
 *2016年11月7日  下午1:36:43
 */
public class AddDesktop extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String result;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		  PrintWriter writer=resp.getWriter();
		
	      String name=req.getParameter("name");
	      String ownName=req.getParameter("ownName");
	      String ownNum=req.getParameter("ownNum");
	      Desktop  desktop=new Desktop();
	      
	      desktop.setName(name!=null ? name :"");
	      desktop.setOwnName(ownName!=null ? ownName : "");
	      desktop.setOwnNum((ownNum!=null&&StringUtil.isInteger(ownNum)) ? Integer.parseInt(ownNum) : 0);
	      
	      AddDesktopService service=new AddDesktopService();
	      int res=service.addDesktop(desktop);
	      result=res>0 ?JsonUtil.getEmlloyeeList(null, Contast.RESULT_SUCCESS_CODE, Contast.RESULT_SUCCESS_MSG)
					:
						JsonUtil.getEmlloyeeList(null, Contast.RESULT_FAIL_CODE, Contast.RESULT_FAIL_MSG)
					;	      
	      writer.print(result);
	      writer.flush();
	      writer.close();
	      
		
	}
	

}
