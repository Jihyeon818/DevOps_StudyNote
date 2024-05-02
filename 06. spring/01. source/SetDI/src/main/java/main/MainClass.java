package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Test;

public class MainClass {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");

		Test t = ctx.getBean("test1",Test.class);
		System.out.println(t.getD1());
		System.out.println(t.getD2());
		System.out.println(t.getD3());
		System.out.println(t.isD4());
		System.out.println(t.getD5());
		System.out.println(t.getD6());
		
		ctx.close();
		
	}
}


