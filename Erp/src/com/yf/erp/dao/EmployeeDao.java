/**
 * 
 */
package com.yf.erp.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yf.erp.bean.Employee;
import com.yf.erp.db.DaoAccess;

/**
 * @author 杨朗飞
 *2016年11月3日  下午1:47:18
 */
public class EmployeeDao{
	
	public  List<Employee>  querryAll(){
		List<Employee> employees=new ArrayList<Employee>();
		SqlSession session=null;
		try {
			session=DaoAccess.getSession();
			employees=session.selectList("Employee.selectEmployee");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return employees;
	}
	
	
	public int addEmployee(Employee employee){
		int restlt = 0;
		SqlSession session=null;
		try {
			session=DaoAccess.getSession();
			restlt=session.insert("Employee.addEmployee",employee);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return restlt;
	}
	
	public int delEmployee(int id){
		int restlt = 0;
		SqlSession session=null;
		try {
			session=DaoAccess.getSession();
			restlt=session.delete("Employee.delEmployee",id);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return restlt;
	}
	
	
	
	public int updateEmployee(Employee employee){
		int restlt = 0;
		SqlSession session=null;
		try {
			session=DaoAccess.getSession();
			restlt=session.update("Employee.updateEmployee",employee);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return restlt;
	}
	
	
	

}
