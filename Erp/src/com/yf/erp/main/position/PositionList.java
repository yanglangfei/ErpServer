package com.yf.erp.main.position;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.erp.bean.Position;
import com.yf.erp.service.PositionListService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;

/**
 * @author 杨朗飞 2016年11月7日 下午3:41:15
 * 
 *         获取岗位信息
 */
public class PositionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		PositionListService service = new PositionListService();
		List<Position> positions = service.querryPosition();
		result = JsonUtil.getPositionList(Contast.RESULT_SUCCESS_CODE,
				Contast.RESULT_SUCCESS_MSG, positions);
		writer.print(result);
		writer.flush();
		writer.close();

	}

}
