package com.yf.erp.util;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.yf.erp.bean.Employee;

public class JsonUtil {

	public static String getOpResult(int code,String msg) {
	    JsonObject object=new JsonObject();
	    
	    object.addProperty("resultCode", code);
	    object.addProperty("resultMsg", msg);
		return object.toString();
	}

	public static String getEmlloyeeList(List<Employee> list,int code,String msg) {
		JsonObject object=new JsonObject();
		object.addProperty("resultCode", code);
	    object.addProperty("resultMsg", msg);
	    
	    JsonArray array=new JsonArray();
	    if(list!=null){
	    	  for (Employee e : list) {
	  	    	JsonObject emp=new JsonObject();
	  	    	emp.addProperty("id",e.getId());
	  	    	emp.addProperty("no", e.getNo());
	  	    	emp.addProperty("name", e.getName());
	  	    	emp.addProperty("sex", e.getSex());
	  	    	
	  	    	emp.addProperty("birth",e.getBirth());
	  	    	emp.addProperty("weight", e.getWeight());
	  	    	emp.addProperty("homeAddress", e.getHomeAddress());
	  	    	emp.addProperty("localAddress", e.getLocalAddress());
	  	    	emp.addProperty("headFace", e.getHeadFace());
	  	    	
	  	    	emp.addProperty("joinDate",e.getJoinDate());
	  	    	emp.addProperty("delop", e.getDelop());
	  	    	emp.addProperty("score", e.getScore());
	  	    	emp.addProperty("team", e.getTeam());
	  	    	array.add(emp);
	  		}
	    }
	    object.add("data", array);
		
		return object.toString();
	}

}
