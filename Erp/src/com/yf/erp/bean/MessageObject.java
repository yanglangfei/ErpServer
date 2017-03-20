package com.yf.erp.bean;

/**
 * @author 杨朗飞
 *2017年3月20日  下午2:26:19
 */
public class MessageObject {

	/**
	 *  消息id
	 */
	private int id;
	
	/**
	 *  消息 内容
	 */
	private String msg;
	
	/**
	 *   消息类型 0   
	 */
	private int msgType;
	
	/**
	 *   发送者id
	 */
	private int fromId;
	
	/**
	 *   接受者id
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
