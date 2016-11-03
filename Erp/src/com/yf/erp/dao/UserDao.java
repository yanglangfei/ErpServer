/**
 * 
 */
package com.yf.erp.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;

import com.yf.erp.bean.User;
import com.yf.erp.db.DaoAccess;
import com.yf.erp.util.MD5Util;

/**
 * @author 杨朗飞
 *  2016年11月2日  下午6:29:32
 */
public class UserDao {
	
	
	public void addUser(User user){
		SqlSession session = null;
		try {
			 session = DaoAccess.getSession();
			 int result=session.insert("com.yf.erp.config.user.addUser",user);
			 if(result>0){
				 System.out.println("添加成功:"+result);
			 }else{
				 System.out.println("添加失败");
			 }
			 session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	
	
	
	
	public void queryAll(){
		SqlSession session = null;
		try {
			 session = DaoAccess.getSession();
			 List<User> user=session.selectList("com.yf.erp.config.user.selectUser");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
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
