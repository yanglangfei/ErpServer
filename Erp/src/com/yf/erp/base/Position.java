/**
 * 
 */
package com.yf.erp.base;

import java.io.Serializable;

/**
 * @author ���ʷ�
 *2016��11��4��  ����5:21:44
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
