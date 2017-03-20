package com.yf.erp.test;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import com.yf.erp.bean.MessageObject;
@SuppressWarnings("unchecked")
public class HandleMessage {
	/**
	 * @param context  ������
	 * @return ��ȡ��id
	 */
	public static  int getTopId(ServletContext context){
		List<MessageObject> attribute = (List<MessageObject>) context.getAttribute("msgList");
		if(attribute==null){
			return 1;
		}
		return attribute.get(attribute.size()-1).getId()+1;
	}
	
	
	/**
	 * @param context  ������
	 * @param msgObj   ��Ϣ����
	 * @return �洢��Ϣ
	 * 
	 */
	public static void saveMessage(ServletContext context,MessageObject msgObj){
		List<MessageObject> attribute = (List<MessageObject>) context.getAttribute("msgList");
		if(attribute==null){
			attribute=new ArrayList<MessageObject>();
		}
		attribute.add(msgObj);
		context.setAttribute("msgList", attribute);
	}
	
	
	/**
	 * @param context  ������
	 * @param top   ������Ϣid
	 * @return  ��ȡ��Ϣ
	 */
	public static List<MessageObject>  getMessage(ServletContext context,int top,boolean isCheck){
		List<MessageObject> attribute = (List<MessageObject>) context.getAttribute("msgList");
		List<MessageObject>   topMessage=new ArrayList<MessageObject>();
		if(attribute==null){
			return new ArrayList<MessageObject>();
		}else{
			for (MessageObject messageObject : attribute) {
				int id = messageObject.getId();
				if(id>top){
					topMessage.add(messageObject);
				}
			}
			return topMessage;
		}
	}
	
}
