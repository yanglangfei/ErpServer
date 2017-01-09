package com.yf.erp.util;
import java.util.Collection;
import java.util.UUID;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;
public class PushUtil {
	public void pushMessage(String msg){
		//��ȡContext ����
		WebContext context=WebContextFactory.get();
		//��ȡ���д�ҳ���session����
		Collection sessions = context.getAllScriptSessions();
		ScriptSession session = context.getScriptSession();
		String uId = (String) session.getAttribute("userId");
		if(uId==null||"".equals(uId)){
			session.setAttribute("userId", UUID.randomUUID().toString());
		}
		String id=(String) session.getAttribute("userId");
		System.out.println("uId:"+id);
		//����script �ű�
		ScriptBuffer sb=new ScriptBuffer();
		//����back������������msg����
		sb.appendScript("back(");
		sb.appendData(id+":"+msg);
		sb.appendScript(")");
		//��session���ϴ���util����
		Util util=new Util(sessions);
		//������Ϣ
		util.addScript(sb);
	}

}
