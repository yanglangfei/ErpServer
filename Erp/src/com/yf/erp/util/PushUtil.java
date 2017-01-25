package com.yf.erp.util;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PushUtil {

/*	*//**
	 * 绑定id
	 *//*
	public void setId(ScriptSession session) {
		String token = getId(session);
		if (token != null && !"".equals(token)) {
			session.setAttribute("token", UUID.randomUUID().toString());
		}
	}

	*//**
	 * 获取id
	 *//*
	public String getId(ScriptSession session) {
		return (String) session.getAttribute("token");
	}

	*//**
	 * @param sessions
	 * @param type
	 *//*
	public void getToSessions(Collection sessions, int type) {
		Collection toSessions = new ArrayList<ScriptSession>();

	}*/

	public void getUserInfo() {
		WebContext context = WebContextFactory.get();
		ScriptSession session = context.getScriptSession();
		String uId = (String) session.getAttribute("userId");
		if (uId == null || "".equals(uId)) {
			session.setAttribute("userId", UUID.randomUUID().toString());
		}

		Collection sessions = context.getAllScriptSessions();
		Iterator inters = sessions.iterator();
		JsonArray array = new JsonArray();
		while (inters.hasNext()) {
			JsonObject object = new JsonObject();
			ScriptSession sion = (ScriptSession) inters.next();
			object.addProperty("userId", (String) sion.getAttribute("userId"));
			object.addProperty("id", sion.getId());
			object.addProperty("createTime", sion.getCreationTime());
			object.addProperty("lastTime", sion.getLastAccessedTime());
			array.add(object);
		}

		ScriptBuffer sb = new ScriptBuffer();
		sb.appendScript("getUser(");
		sb.appendData(array.toString());
		sb.appendScript(")");
		Util util = new Util(sessions);
		util.addScript(sb);
	}

	/**
	 * @param msg
	 *            推送消息
	 */
	public void pushMessage(String msg, String isAll) {
		// 获取Context 对象
		Util util = null;
		ScriptSession currentSession = null;
		WebContext context = WebContextFactory.get();
		String id = (String) context.getScriptSession().getAttribute("userId");
		// 获取所有打开页面的session集合
		Collection sessions = context.getAllScriptSessions();
		// 创建script 脚本
		ScriptBuffer sb = new ScriptBuffer();
		// 调用back方法，并传递msg参数
		sb.appendScript("back(");
		sb.appendData(id + ":" + msg);
		sb.appendScript(")");
		
		// 群聊
		util = new Util(sessions);
		// 推送消息
		util.addScript(sb);
		
		
	   /*	
		if (isAll.equals("全部")) {
			// 群聊
			util = new Util(sessions);
			// 推送消息
			util.addScript(sb);

		} else {
			Iterator inters = sessions.iterator();
			while (inters.hasNext()) {
				ScriptSession sion = (ScriptSession) inters.next();
				String uId = (String) sion.getAttribute("userId");
				if (uId.equals(isAll)) {
					currentSession = sion;
					break;
				}
			}
			// 单聊
			util = new Util(currentSession);
			// 推送消息
			util.addScript(sb);
			
		}
		
	}*/
	}

}
