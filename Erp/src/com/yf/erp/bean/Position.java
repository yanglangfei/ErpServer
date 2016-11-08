/**
 * 
 */
package com.yf.erp.bean;

import java.io.Serializable;

/**
 * @author 杨朗飞
 *2016年11月4日  下午5:21:44
 */
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 *  岗位id
	 */
	private int id;
	/**
	 *   岗位名称 
	 */
	private String name;
	/**
	 *   所属部门
	 */
	private int deptId;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

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
	
	

}
