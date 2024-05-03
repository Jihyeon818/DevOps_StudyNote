package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Test;
import beans.Test2;
import beans.Test3;
import config.BeanClass;


public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanClass.class);
		
		Test t1 = ctx.getBean(Test.class);
		System.out.println(t1.getD1());
		System.out.println(t1.getD2());
		System.out.println(t1.getD3());
		System.out.println(t1.getD4());
		System.out.println(t1.getD5());
	
		System.out.println("--------생성자로 데이터를 넣은 경우-----------------");
		Test2 t2 = ctx.getBean(Test2.class);
		System.out.println(t2.getD1());
		System.out.println(t2.getD2());
		System.out.println(t2.getD3());
		System.out.println(t2.getD4());
		
		System.out.println("---Bean에서 데이터를 다시 넣은 경우 새로 넣어진 값 출력----");
		Test3 t3 = ctx.getBean("t3",Test3.class);
		System.out.println(t3.getD1());
		System.out.println(t3.getD2());
		System.out.println(t3.getD3());
		System.out.println(t3.getD4());
		
		ctx.close();
	}
}


