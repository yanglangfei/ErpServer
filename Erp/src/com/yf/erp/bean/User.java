/**
 * 
 */
package com.yf.erp.bean;

import java.io.Serializable;

/**
 * @author ���ʷ�
 *2016��11��2��  ����6:21:17
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String password;
	
	
	public User() {
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
