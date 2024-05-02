package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import beans.Test;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		//로딩되면서 생성자가 호출되어 함수(syso) 실행됨
		//xml에서 lazy-init을 true로 해주면 생성 시 함수 호출하지 않게됨
		
		Test t1 = ctx.getBean("test1", Test.class);
		System.out.println(t1);
		
		Test t2 = ctx.getBean("test2", Test.class);
		System.out.println(t2);
		Test t22 = ctx.getBean("test2", Test.class);
		System.out.println(t22);
		
		Test t3 = ctx.getBean("test3", Test.class);
		System.out.println(t3);
		Test t4 = ctx.getBean("test3", Test.class);
		System.out.println(t4);
	}
}


