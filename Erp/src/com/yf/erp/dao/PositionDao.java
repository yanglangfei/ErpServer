package com.yf.erp.dao;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yf.erp.bean.Position;
import com.yf.erp.db.DaoAccess;
public class PositionDao {
	
	/**
	 * @param position
	 * @return  ���ְλ��Ϣ
	 */
	public int addPosition(Position position){
		SqlSession session = null;
		int result=0;
		try {
			session=DaoAccess.getSession();
			result=session.insert("Position.addPosition", position);
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
	 * @return   ��ȡ����ְλ��Ϣ
	 */
	public List<Position> querryPositionList(){
		SqlSession session = null;
		List<Position> result=new ArrayList<Position>();
		try {
			session=DaoAccess.getSession();
			result=session.selectList("Position.selectPosition");
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
	 * @return    �޸�ְλ��Ϣ
	 */
	public int updatePosition(Position position){
		SqlSession session = null;
		int result=0;
		try {
			session=DaoAccess.getSession();
			result=session.update("Position.updatePosition",position);
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
	 * @return  ɾ��������Ϣ
	 */
	public int delPosition(int id){
		SqlSession session=null;
		int result=0;
		try {
			session=DaoAccess.getSession();
			result=session.update("Position.delPosition");
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
