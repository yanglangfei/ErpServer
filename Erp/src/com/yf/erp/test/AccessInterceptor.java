package com.yf.erp.test;

public class AccessInterceptor extends Person{

	@Override
	public void work() {
		this.eat();
		System.out.println("access:"+age);
		
	}
	
	
	@Override
	public void eat() {
		super.eat();
	}
	


	public static void main(String[] args) {
		AccessInterceptor accessInterceptor=new AccessInterceptor();
		accessInterceptor.work();
	}
	
	
	
	

}
