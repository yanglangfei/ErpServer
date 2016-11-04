/**
 * 
 */
package com.yf.erp.base;

import java.io.Serializable;

/**
 * @author 杨朗飞
 *2016年11月4日  下午5:21:44
 */
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;

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
