package com.yf.erp.main.emp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yf.erp.bean.Employee;
import com.yf.erp.service.UpdateEmployeeService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
import com.yf.erp.util.StringUtil;

public class UpdateEmployee extends HttpServlet{
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
		String no = req.getParameter("no");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String weight=req.getParameter("weight");
		String birth=req.getParameter("birth");
		String homeAddress=req.getParameter("homeAddress");
		String localAddress=req.getParameter("localAddress");
		String headFace=req.getParameter("headFace");
		String joinDate=req.getParameter("joinDate");
		String delop=req.getParameter("delop");
		String scoreId=req.getParameter("scoreId");
		String teamId=req.getParameter("teamId");
		Employee employee=new Employee();
		if(id!=null&&id!=""){
			if(StringUtil.isInteger(id)){
				int index=Integer.parseInt(id);
				employee.setId(index);
				if(no!=null&&no!=""){
					employee.setNo(no);
				}
				
				if(name!=null&&name!=""){
					employee.setName(name);
				}
				
				if(sex!=null&&sex!=""){
					if(StringUtil.isInteger(sex)){
						int s=Integer.parseInt(sex);
						employee.setSex(s);
					}
				}
				
				if(weight!=null&&weight!=""){
					if(StringUtil.isInteger(weight)){
						int weit=Integer.parseInt(weight);
						employee.setWeight(weit);
					}
				}
				
				if(birth!=null&&birth!=""){
					employee.setBirth(birth);
				}
				
				if(homeAddress!=null&&homeAddress!=""){
					employee.setHomeAddress(homeAddress);
				}
				
				if(localAddress!=null&&localAddress!=""){
					employee.setLocalAddress(localAddress);
				}
				
				if(headFace!=null&&headFace!=""){
					employee.setHeadFace(headFace);
				}
				
				if(joinDate!=null&&joinDate!=""){
					employee.setJoinDate(joinDate);
				}
				
				if(delop!=null&&delop!=""){
					if(StringUtil.isInteger(delop)){
						int dep=Integer.parseInt(delop);
						employee.setDelop(dep);
					}
				}
				
				if(scoreId!=null&&scoreId!=""){
					if(StringUtil.isInteger(scoreId)){
						int score=Integer.parseInt(scoreId);
						employee.setScoreId(score);
					}
				}
				
				if(teamId!=null&&teamId!=""){
					if(StringUtil.isInteger(teamId)){
						int team=Integer.parseInt(teamId);
						employee.setTeamId(team);
					}
				}
				
				UpdateEmployeeService service=new UpdateEmployeeService();
				int res=service.updateEmployee(employee);
				result=res>0 ?JsonUtil.getEmlloyeeList(null, Contast.RESULT_SUCCESS_CODE, Contast.RESULT_SUCCESS_MSG)
						:
							JsonUtil.getEmlloyeeList(null, Contast.RESULT_FAIL_CODE, Contast.RESULT_FAIL_MSG)
						;
				
				
				
				
			}
		}
		
		writer.print(result);
		writer.flush();
		writer.close();
		
	}

}
