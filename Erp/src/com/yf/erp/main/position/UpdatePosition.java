package com.yf.erp.main.position;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.erp.bean.Position;
import com.yf.erp.service.AddPositionService;
import com.yf.erp.service.UpdatePositionService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
import com.yf.erp.util.StringUtil;

/**
 * @author 杨朗飞
 *2016年11月7日  下午4:21:42
 *
 *  修改岗位信息
 */
public class UpdatePosition extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer=resp.getWriter();
		String name=req.getParameter("name");
		String deptId=req.getParameter("deptId");
		
		Position position=new Position();
		position.setName(name);
		position.setDeptId(StringUtil.isNotNull(deptId)&&StringUtil.isInteger(deptId) ?Integer.parseInt(deptId) : 0);
	
	   int res=new UpdatePositionService().updatePosition(position);
	   String result = res>0 ?JsonUtil.getEmlloyeeList(null, Contast.RESULT_SUCCESS_CODE, Contast.RESULT_SUCCESS_MSG)
				:
					JsonUtil.getEmlloyeeList(null, Contast.RESULT_FAIL_CODE, Contast.RESULT_FAIL_MSG)
				;	      
     writer.print(result);
     writer.flush();
     writer.close();
		
	}

}
