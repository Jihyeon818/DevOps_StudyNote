package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Test;
import beans.Test2;
import config.BeanClass;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanClass.class);
		
		Test t = ctx.getBean("test1",Test.class);
		System.out.println(t.getD3());
		System.out.println(t.getD4());
		System.out.println(t.getD5());
		
		Test2 t2 = ctx.getBean("test2",Test2.class);
		System.out.println(t2.getD1());
		System.out.println(t2.getD2());
		System.out.println(t2.getD3());
		System.out.println(t2.getD4());
		
		ctx.close();
	}
}


