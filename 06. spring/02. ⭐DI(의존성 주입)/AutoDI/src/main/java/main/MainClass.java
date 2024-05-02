package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Test;
import beans.Test2;
import beans.Test3;

public class MainClass {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");

		Test t = ctx.getBean("test1",Test.class);
		System.out.println(t);
		System.out.println(t.getD1()); //객체의 주소값 출력
		System.out.println(t.getD2());
		System.out.println("");
		
		Test t2 = ctx.getBean("test2", Test.class);
		System.out.println(t2);
		System.out.println("");
		
		Test2 t3 = ctx.getBean("test3", Test2.class);
		System.out.println(t3);
		System.out.println(t3.getD1());
		System.out.println(t3.getD2());
		System.out.println("");
		
		Test3 t4 = ctx.getBean("test4", Test3.class);
		System.out.println(t4);
		System.out.println(t4.getD1());
		System.out.println(t4.getD2());
		System.out.println("");
		
		Test3 t5 = ctx.getBean("test5", Test3.class);
		System.out.println(t5);
		
		ctx.close();
		
	}
}


