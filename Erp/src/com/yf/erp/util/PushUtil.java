package com.yf.erp.util;

import java.util.Collection;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;
public class PushUtil {
	public void pushMessage(String msg){
		System.out.println("pushMessage...");
		WebContext context=WebContextFactory.get();
		Collection sessions = context.getAllScriptSessions();
		ScriptBuffer sb=new ScriptBuffer();
		sb.appendScript("back(");
		sb.appendData(msg);
		sb.appendScript(")");
		Util util=new Util(sessions);
		util.addScript(sb);
		System.out.println("addSb:"+msg);
	}

}
