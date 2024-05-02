package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Test;
import config.BeanClass;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanClass.class);
		
		Test t1 = ctx.getBean("test1",Test.class);
		System.out.println(t1);
		
		ctx.close();
	}
}


