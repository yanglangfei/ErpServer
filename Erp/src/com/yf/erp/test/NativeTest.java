package com.yf.erp.test;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.util.User32;

public class NativeTest {
	
	public static void main(String[] args) {
		 try {
			  //系统加载dll文件有两种写法1.loadLibrary方法:把dll文件拷贝到c:\windows\system32目录下,引用时只需写dll名字2.load方法:写dll文件的完整路径
			   System.loadLibrary("JNativeCpp");//InterfaceFun是dll文件
			   
			   User32.MessageBox(0, "很好滴滴", "ok is goods", 0);
			   System.out.println(JNative.isWindows());
			   
			   
			/*   
			   //参数说明InterfaceFun dll名,AddZhiYe函数名
			   JNative jnative = new JNative("InterfaceFun","AddZhiYe");
			   //设置此函数的返回值
			   jnative.setRetVal(Type.INT);
			   int i=0;
			   //赋予参数值
			   jnative.setParameter(i++, Type.STRING,"127.0.0.1");
			   jnative.setParameter(i++, Type.STRING,"sa");
			   jnative.setParameter(i++, Type.STRING,"sa");
			   jnative.setParameter(i++, Type.STRING,"程序员");
			   jnative.setParameter(i++, Type.INT,"23");
			   jnative.setParameter(i++, Type.INT,"23");
			   //函数执行
			   jnative.invoke();
			   //打印函数返回值
			   System.out.println(Integer.parseInt(jnative.getRetVal()));*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}

}
