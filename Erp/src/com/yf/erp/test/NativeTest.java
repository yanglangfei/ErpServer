package com.yf.erp.test;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.util.User32;

public class NativeTest {
	
	public static void main(String[] args) {
		 try {
			  //ϵͳ����dll�ļ�������д��1.loadLibrary����:��dll�ļ�������c:\windows\system32Ŀ¼��,����ʱֻ��дdll����2.load����:дdll�ļ�������·��
			   System.loadLibrary("JNativeCpp");//InterfaceFun��dll�ļ�
			   
			   User32.MessageBox(0, "�ܺõε�", "ok is goods", 0);
			   System.out.println(JNative.isWindows());
			   
			   
			/*   
			   //����˵��InterfaceFun dll��,AddZhiYe������
			   JNative jnative = new JNative("InterfaceFun","AddZhiYe");
			   //���ô˺����ķ���ֵ
			   jnative.setRetVal(Type.INT);
			   int i=0;
			   //�������ֵ
			   jnative.setParameter(i++, Type.STRING,"127.0.0.1");
			   jnative.setParameter(i++, Type.STRING,"sa");
			   jnative.setParameter(i++, Type.STRING,"sa");
			   jnative.setParameter(i++, Type.STRING,"����Ա");
			   jnative.setParameter(i++, Type.INT,"23");
			   jnative.setParameter(i++, Type.INT,"23");
			   //����ִ��
			   jnative.invoke();
			   //��ӡ��������ֵ
			   System.out.println(Integer.parseInt(jnative.getRetVal()));*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}

}
