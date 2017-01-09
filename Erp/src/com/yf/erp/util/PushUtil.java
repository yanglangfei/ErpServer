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
		//获取Context 对象
		WebContext context=WebContextFactory.get();
		//获取所有打开页面的session集合
		Collection sessions = context.getAllScriptSessions();
		ScriptSession session = context.getScriptSession();
		String uId = (String) session.getAttribute("userId");
		if(uId==null||"".equals(uId)){
			session.setAttribute("userId", UUID.randomUUID().toString());
		}
		String id=(String) session.getAttribute("userId");
		System.out.println("uId:"+id);
		//创建script 脚本
		ScriptBuffer sb=new ScriptBuffer();
		//调用back方法，并传递msg参数
		sb.appendScript("back(");
		sb.appendData(id+":"+msg);
		sb.appendScript(")");
		//以session集合创建util对象
		Util util=new Util(sessions);
		//推送消息
		util.addScript(sb);
	}

}
