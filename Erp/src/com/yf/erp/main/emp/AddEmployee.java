package com.yf.erp.main.emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.erp.bean.Employee;
import com.yf.erp.service.AddEmployeeService;
import com.yf.erp.util.Contast;
import com.yf.erp.util.JsonUtil;
import com.yf.erp.util.StringUtil;
public class AddEmployee extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String result;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer=resp.getWriter();
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
		if(StringUtil.isInteger(scoreId)){
			int s=Integer.parseInt(scoreId);
			if(StringUtil.isInteger(sex)){
				int sexs=Integer.parseInt(sex);
				if(StringUtil.isInteger(delop)){
					int dep=Integer.parseInt(delop);
					if(StringUtil.isInteger(teamId)){
						int team=Integer.parseInt(teamId);
						if(StringUtil.isDouble(weight)){
							int wet=Integer.parseInt(weight);
							Employee employee=new Employee();
							employee.setNo(no);
							employee.setName(name);
							employee.setSex(sexs);
							employee.setWeight(wet);
							employee.setBirth(birth);
							employee.setHomeAddress(homeAddress);
							employee.setLocalAddress(localAddress);
							employee.setHeadFace(headFace);
							employee.setJoinDate(joinDate);
							employee.setDelop(dep);
							employee.setScoreId(s);
							employee.setTeamId(team);
							AddEmployeeService service=new AddEmployeeService();
							int res=service.addEmployee(employee);
							result=res>0 ?JsonUtil.getEmlloyeeList(null, Contast.RESULT_SUCCESS_CODE, Contast.RESULT_SUCCESS_MSG)
									:
										JsonUtil.getEmlloyeeList(null, Contast.RESULT_FAIL_CODE, Contast.RESULT_FAIL_MSG)
									;
						}else{
							System.out.println("参数异常1:"+weight);
						}
						
					}else{
						System.out.println("参数异常2:"+teamId);
					}
				}else{
					System.out.println("参数异常3:"+delop);
				}
			}else{
				System.out.println("参数异常4:"+sex);
			}
			
			
		}else{
			System.out.println("参数异常5:"+scoreId);
		}
		
		writer.print(result);
		writer.flush();
		writer.close();
		
	}

}
