package com.yf.erp.util;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.yf.erp.bean.Desktop;
import com.yf.erp.bean.Employee;
import com.yf.erp.bean.Position;
import com.yf.erp.main.model.Applicate;

public class JsonUtil {

	public static String getOpResult(int code, String msg) {
		JsonObject object = new JsonObject();

		object.addProperty("resultCode", code);
		object.addProperty("resultMsg", msg);
		return object.toString();
	}

	/**
	 * @param list
	 * @param code
	 * @param msg
	 * @return  获取员工列表
	 */
	public static String getEmlloyeeList(List<Employee> list, int code,
			String msg) {
		JsonObject object = new JsonObject();
		object.addProperty("resultCode", code);
		object.addProperty("resultMsg", msg);

		JsonArray array = new JsonArray();
		if (list != null) {
			for (Employee e : list) {
				JsonObject emp = new JsonObject();
				emp.addProperty("id", e.getId());
				emp.addProperty("no", e.getNo());
				emp.addProperty("name", e.getName());
				emp.addProperty("sex", e.getSex());

				emp.addProperty("birth", e.getBirth());
				emp.addProperty("weight", e.getWeight());
				emp.addProperty("homeAddress", e.getHomeAddress());
				emp.addProperty("localAddress", e.getLocalAddress());
				emp.addProperty("headFace", e.getHeadFace());

				emp.addProperty("joinDate", e.getJoinDate());
				emp.addProperty("delop", e.getDelop());
				emp.addProperty("score", e.getScoreId());
				emp.addProperty("team", e.getTeamId());
				array.add(emp);
			}
		}
		object.add("data", array);

		return object.toString();
	}

	/**
	 * @param code
	 * @param msg
	 * @param desktops
	 * @return  获取部门列表
	 */
	public static String getDesktopList(int code,String msg,List<Desktop> desktops) {
		JsonObject object = new JsonObject();
		object.addProperty("resultCode", code);
		object.addProperty("resultMsg", msg);

		JsonArray array = new JsonArray();
		if (desktops != null) {
			for (Desktop desktop : desktops) {
				JsonObject dept = new JsonObject();
				dept.addProperty("id", desktop.getId());
				dept.addProperty("name", desktop.getName());
				dept.addProperty("ownName",desktop.getOwnName());
				dept.addProperty("ownNum", desktop.getOwnNum());
				array.add(dept);
			}
		}
		object.add("data", array);

		return object.toString();
	}

	/**
	 * @param resultSuccessCode
	 * @param resultSuccessMsg
	 * @param positions
	 * @return  获取所有职位信息
	 */
	public static String getPositionList(int resultSuccessCode,
			String resultSuccessMsg, List<Position> positions) {
		JsonObject object = new JsonObject();
		object.addProperty("resultCode", resultSuccessCode);
		object.addProperty("resultMsg", resultSuccessMsg);

		JsonArray array = new JsonArray();
		if (positions != null) {
			for (Position position : positions) {
				JsonObject dept = new JsonObject();
				dept.addProperty("id", position.getId());
				dept.addProperty("name", position.getName());
				dept.addProperty("deptId",position.getDeptId());
				array.add(dept);
			}
		}
		object.add("data", array);

		return object.toString();
	}

	
	/*
	 * 分模块更新
	 */
	public static String getModelData(int code,String msg) {
		JsonObject object=new JsonObject();
		object.addProperty("ret_code",code);
		object.addProperty("msg", msg);
		
		JsonObject modelData=new JsonObject();
		modelData.addProperty("version", 3.5);
		modelData.addProperty("downLoadPath", "");
		modelData.addProperty("fileName", "");
		
		JsonArray models=new JsonArray();
		for(int i=0;i<2;i++){
			JsonObject model=new JsonObject();
			model.addProperty("packageName", "");
			model.addProperty("uuid", "");
			JsonObject layoutParams=new JsonObject();
			layoutParams.addProperty("width", -1);
			layoutParams.addProperty("height", -1);
			model.add("layoutParams", layoutParams);
		}
		modelData.add("viewInfo", models);
		object.add("data", modelData);
		return object.toString();
	}

	/**
	 * @param app
	 * @return  
	 */
	public static String getUpdateInfo(Applicate app) {
		JsonObject object=new JsonObject();
		object.addProperty("versionCode", app.getVersionCode());
		object.addProperty("versionName", app.getVersionName());
		object.addProperty("url", app.getUrl());
		object.addProperty("content", app.getContent());
		object.addProperty("mustUpdate", app.isMustUpdate());
		return object.toString();
	}

}
