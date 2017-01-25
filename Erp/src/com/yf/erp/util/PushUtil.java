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
	 * ��id
	 *//*
	public void setId(ScriptSession session) {
		String token = getId(session);
		if (token != null && !"".equals(token)) {
			session.setAttribute("token", UUID.randomUUID().toString());
		}
	}

	*//**
	 * ��ȡid
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
	 *            ������Ϣ
	 */
	public void pushMessage(String msg, String isAll) {
		// ��ȡContext ����
		Util util = null;
		ScriptSession currentSession = null;
		WebContext context = WebContextFactory.get();
		String id = (String) context.getScriptSession().getAttribute("userId");
		// ��ȡ���д�ҳ���session����
		Collection sessions = context.getAllScriptSessions();
		// ����script �ű�
		ScriptBuffer sb = new ScriptBuffer();
		// ����back������������msg����
		sb.appendScript("back(");
		sb.appendData(id + ":" + msg);
		sb.appendScript(")");
		
		// Ⱥ��
		util = new Util(sessions);
		// ������Ϣ
		util.addScript(sb);
		
		
	   /*	
		if (isAll.equals("ȫ��")) {
			// Ⱥ��
			util = new Util(sessions);
			// ������Ϣ
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
			// ����
			util = new Util(currentSession);
			// ������Ϣ
			util.addScript(sb);
			
		}
		
	}*/
	}

}
