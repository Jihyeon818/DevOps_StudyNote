package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Test;
import beans.Test2;

public class MainClass {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");

		Test t1 = ctx.getBean("test", Test.class);
		t1.show();

		Test t2 = ctx.getBean("test2", Test.class);
		t2.show();
		
		Test t3 = ctx.getBean("test3", Test.class);
		t3.show();
		
		Test t4 = ctx.getBean("test4", Test.class);
		t4.show();
		
		Test t5 = ctx.getBean("test5", Test.class);
		t5.show();
		
		Test2 t6 = ctx.getBean("test6", Test2.class);
		t6.show();
		
		Test2 t7 = ctx.getBean("test7", Test2.class);
		t7.show();
		
		ctx.close();
		
	}
}


