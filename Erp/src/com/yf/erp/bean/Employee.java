/**
 * 
 */
package com.yf.erp.bean;

import java.io.Serializable;

/**
 * @author ���ʷ�
 *2016��11��2��  ����6:15:54
 */
public class Employee implements Serializable {
	private static long serialVersionUID = 1L;
	/**
	 *  id
	 */
	private int id;
	/**
	 *   ���
	 */
	private String no;
	/**
	 * ����
	 */
	private String name;
	/**
	 *   �Ա�
	 */
	private int sex;
	
	private double weight;
	/**
	 *  ��������
	 */
	private String birth;
	/**
	 *  �������ڵ�
	 */
	private String homeAddress;
	/**
	 *   �ݾӵ�
	 */
	private String localAddress;
	/**
	 *   ͷ��
	 */
	private String headFace;
	/**
	 *   ��ְʱ��
	 */
	private String joinDate;
	/**
	 *   ���ڲ���
	 */
	private int delop;
	/**
	 *   �ۺ�ҵ��
	 */
	private int scoreId;
	/**
	 *   �����Ŷ�
	 */
	private int teamId;
	
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}
	public String getHeadFace() {
		return headFace;
	}
	public void setHeadFace(String headFace) {
		this.headFace = headFace;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	public int getDelop() {
		return delop;
	}
	public void setDelop(int delop) {
		this.delop = delop;
	}
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	
}
