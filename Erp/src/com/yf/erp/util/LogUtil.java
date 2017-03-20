package com.yf.erp.util;

public class LogUtil {
	
	
	/**
	 * @param logInfo   log ��Ϣ
	 * @param isDebug   �����Ƿ����
	 */
	public static void print(String logInfo,boolean isDebug){
		StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
		System.out.println(logInfo+"-------------------------"+stackTraceElement.getClassName()+"-----<<"+stackTraceElement.getMethodName()+">>>>>-----"+stackTraceElement.getLineNumber());
		
		
	}

}
