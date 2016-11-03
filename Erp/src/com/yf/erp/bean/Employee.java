/**
 * 
 */
package com.yf.erp.bean;

import java.io.Serializable;

/**
 * @author 杨朗飞
 *2016年11月2日  下午6:15:54
 */
public class Employee implements Serializable {
	/**
	 *  id
	 */
	private int id;
	/**
	 *   编号
	 */
	private String no;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 *   性别
	 */
	private int sex;
	
	private double weight;
	/**
	 *  出生日期
	 */
	private String birth;
	/**
	 *  家乡所在地
	 */
	private String homeAddress;
	/**
	 *   暂居地
	 */
	private String localAddress;
	/**
	 *   头像
	 */
	private String headFace;
	/**
	 *   入职时间
	 */
	private String joinDate;
	/**
	 *   所在部门
	 */
	private int delop;
	/**
	 *   综合业绩
	 */
	private int score;
	/**
	 *   所属团队
	 */
	private int team;
	
	
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
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getDelop() {
		return delop;
	}
	public void setDelop(int delop) {
		this.delop = delop;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	
	
}
