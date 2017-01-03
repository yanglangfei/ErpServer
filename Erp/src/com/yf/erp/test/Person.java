package com.yf.erp.test;

import com.yf.erp.bean.Human;

public class Person implements Human {

	@Override
	public void eat() {
		System.out.println("age:"+age);

	}

	@Override
	public void speek() {

	}

	@Override
	public void work() {
		System.out.println("person:");
	}
	
	public static void main(String[] args) {
		Person p=new Person();
		p.eat();
	}

}
