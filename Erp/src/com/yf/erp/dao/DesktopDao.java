package com.yf.erp.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yf.erp.bean.Desktop;
import com.yf.erp.db.DaoAccess;

public class DesktopDao {
	
	/**
	 * @param desktop
	 * @return  添加部门信息
	 */
	public int addDesktop(Desktop desktop){
		SqlSession session = null;
		int result=0;
		try {
			session=DaoAccess.getSession();
			result=session.insert("Desktop.addDesktop", desktop);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return result;
	}
	
	
	/**
	 * @return   获取所有部门信息
	 */
	public List<Desktop> querryDesktopList(){
		SqlSession session = null;
		List<Desktop> result=new ArrayList<Desktop>();
		try {
			session=DaoAccess.getSession();
			result=session.selectList("Desktop.selectDesktop");
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return result;
	}
	
	/**
	 * @param desktop
	 * @return  更新部门信息
	 */
	public int updateDesktopInfo(Desktop desktop){
		SqlSession session = null;
		int result = 0;
		try {
			session=DaoAccess.getSession();
			result=session.update("Desktop.updateDesktop",desktop);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return result;
	}
	
	/**
	 * @param id
	 * @return  删除部门信息
	 */
	public int delDesktop(int id){
		SqlSession session = null;
		int result = 0;
		try {
			session=DaoAccess.getSession();
			result=session.delete("Desktop.deleteDesktop",id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return result;
	}
	


}
