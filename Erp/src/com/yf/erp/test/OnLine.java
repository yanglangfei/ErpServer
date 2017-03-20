package com.yf.erp.test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.util.TextUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.yf.erp.bean.MessageObject;
/**
 * @author ���ʷ�
 *2017��3��20��  ����1:48:39
 *
 *  
 */
public class OnLine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  List<String> users=new ArrayList<String>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		HttpSession session = request.getSession();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				
				
			}
			
		}
		
		/*if(session.isNew()){
			//  new session
		}else{
			//  old session
			List<String> attribute = (List<String>) session.getAttribute("list");
			
			attribute.add(0, "hello");
			
			
		}*/
		
		
		//��ȡ���в�������
		Enumeration<String> parameterNames = request.getParameterNames();
		//��ȡ����header����
		Enumeration<String> headerNames = request.getHeaderNames();
		if(parameterNames!=null){
			while (parameterNames.hasMoreElements()) {
				String paramterName = (String) parameterNames.nextElement();
				System.out.println("name:"+paramterName+"  value��"+request.getParameter(paramterName));
			}
		}
		
		if(headerNames!=null){
			while (headerNames.hasMoreElements()) {
				String name = (String) headerNames.nextElement();
				System.out.println("name="+name+"  value="+request.getHeader(name));
			}
		}
		
		System.out.println("update:"+getLastModified(request));
		
		
		String user=request.getParameter("user");
		if(!TextUtils.isEmpty(user)){
			if(!users.contains(user)){
				users.add(user);
				System.out.println("���û�");
			}else{
				System.out.println("���û�");
			}
		}
		int topId = HandleMessage.getTopId(getServletContext());
		
		MessageObject msg=new MessageObject(topId, "hello"+topId, 1, 1, 0);
		HandleMessage.saveMessage(getServletContext(), msg);
		
		JsonArray array=new JsonArray();
		for(String u : users){
			JsonObject object=new JsonObject();
			object.addProperty("name", u);
			array.add(object);
		}
		
		
		
		
		//out.println(array.toString());
		
		List<MessageObject> message = HandleMessage.getMessage(getServletContext(), 0);
		JsonArray msgArray=new JsonArray();
		for (MessageObject messageObject : message) {
			JsonObject object=new JsonObject();
			object.addProperty("msg", messageObject.getMsg());
			object.addProperty("id",messageObject.getId());
			msgArray.add(object);
		}
		
		out.print(msgArray.toString());
		out.flush();
		out.close();
	}
	
	@Override
	protected long getLastModified(HttpServletRequest req) {
		//���һ���޸����ݵ�ʱ��
		return super.getLastModified(req);
	}

}