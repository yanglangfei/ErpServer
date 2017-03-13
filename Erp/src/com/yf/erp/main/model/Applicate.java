package com.yf.erp.main.model;
/**
 * @author ���ʷ�
 *
 */
		
public class Applicate {
	/**
	 *    ���°汾��
	 */
	private int versionCode;
	/**
	 *   ���°汾����
	 */
	private String versionName;
	/**
	 *   ��������
	 */
	private String content;
	/**
	 *   �Ƿ�ǿ�Ƹ���
	 */
	private boolean mustUpdate;
	/**
	 *   ���µ�ַ
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
