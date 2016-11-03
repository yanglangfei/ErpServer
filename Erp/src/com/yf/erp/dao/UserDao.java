/**
 * 
 */
package com.yf.erp.dao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yf.erp.bean.User;
import com.yf.erp.db.DaoAccess;
/**
 * @author ���ʷ�
 *  2016��11��2��  ����6:29:32
 */
public class UserDao {
	
	
	public void addUser(User user){
		SqlSession session = null;
		try {
			 session = DaoAccess.getSession();
			 int result=session.insert("com.yf.erp.config.user.addUser",user);
			 if(result>0){
				 System.out.println("��ӳɹ�:"+result);
			 }else{
				 System.out.println("���ʧ��");
			 }
			 session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	
	
	
	
	public List<User> queryAll(){
		List<User> user=new ArrayList<User>();
		SqlSession session = null;
		try {
			 session = DaoAccess.getSession();
			 user=session.selectList("com.yf.erp.config.user.selectUser");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return user;
	}
	
	
	public User queryUserByName(String userName){
		SqlSession session = null;
		User user = null;
		try {
			 session = DaoAccess.getSession();
			 user= session.selectOne("com.yf.erp.config.user.selectByName",userName);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return user;
	}

}
