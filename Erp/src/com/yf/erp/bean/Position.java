/**
 * 
 */
package com.yf.erp.bean;

import java.io.Serializable;

/**
 * @author ���ʷ�
 *2016��11��4��  ����5:21:44
 */
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 *  ��λid
	 */
	private int id;
	/**
	 *   ��λ���� 
	 */
	private String name;
	/**
	 *   ��������
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
