package com.yf.erp.bean;

/**
 * @author ���ʷ�
 *2017��3��20��  ����2:26:19
 */
public class MessageObject {

	/**
	 *  ��Ϣid
	 */
	private int id;
	
	/**
	 *  ��Ϣ ����
	 */
	private String msg;
	
	/**
	 *   ��Ϣ���� 0   
	 */
	private int msgType;
	
	/**
	 *   ������id
	 */
	private int fromId;
	
	/**
	 *   ������id
	 */
	private int toId;

	public MessageObject(int id, String msg, int msgType, int fromId, int toId) {
		this.id = id;
		this.msg = msg;
		this.msgType = msgType;
		this.fromId = fromId;
		this.toId = toId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	public int getFromId() {
		return fromId;
	}

	public void setFromId(int fromId) {
		this.fromId = fromId;
	}

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

}
