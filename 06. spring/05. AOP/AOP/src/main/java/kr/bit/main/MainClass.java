package kr.bit.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.bit.beans.Test;

public class MainClass {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/bit/config/beans.xml");
		
		Test t1 = ctx.getBean("test1",Test.class);
		int n = t1.Test();
		System.out.println(n);
		
		ctx.close();

	}
}
