package com.yf.erp.main.model;
/**
 * @author 杨朗飞
 *
 */
		
public class Applicate {
	/**
	 *    更新版本号
	 */
	private int versionCode;
	/**
	 *   更新版本名称
	 */
	private String versionName;
	/**
	 *   更新内容
	 */
	private String content;
	/**
	 *   是否强制更新
	 */
	private boolean mustUpdate;
	/**
	 *   更新地址
	 */
	private String url;
	
	
	
	
	public Applicate() {
	}
	public Applicate(int versionCode, String versionName, String content,
			boolean mustUpdate, String url) {
		this.versionCode = versionCode;
		this.versionName = versionName;
		this.content = content;
		this.mustUpdate = mustUpdate;
		this.url = url;
	}
	public int getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isMustUpdate() {
		return mustUpdate;
	}
	public void setMustUpdate(boolean mustUpdate) {
		this.mustUpdate = mustUpdate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
