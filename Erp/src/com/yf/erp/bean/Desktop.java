/**
 * 
 */
package com.yf.erp.bean;

import java.io.Serializable;

/**
 * @author 杨朗飞
 *2016年11月4日  下午2:12:25
 */
public class Desktop implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String ownName;
	
	private int ownNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnName() {
		return ownName;
	}

	public void setOwnName(String ownName) {
		this.ownName = ownName;
	}

	public int getOwnNum() {
		return ownNum;
	}

	public void setOwnNum(int ownNum) {
		this.ownNum = ownNum;
	}
	
}
