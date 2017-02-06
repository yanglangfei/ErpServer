package com.yf.erp.test;

import java.util.TimerTask;

import com.yf.erp.util.FileUtils;
/**
 * Ö´ÐÐÄÚÈÝ
 * @author admin_Hzw
 *
 */
public class Task extends TimerTask {
	String path="C:\\Users\\Administrator\\Desktop\\TEST\\my.txt";
	String content="";
	public void run() {
		
	}
	
	
	public void opFile(){
		FileUtils.createFile(path);
		FileUtils.contentToTxt(path, "\r\n"+content);
	}
	
	
}