package kr.bit.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.bit.beans.Test;
import kr.bit.config.BeansClass;

public class MainClass {
	public static void main(String[] args) {
		
		System.out.println("xml로 bean을 가져올 경우");	
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/bit/config/beans.xml");

		Test t = ctx.getBean(Test.class);
		t.m1();
		
		System.out.println("class로 bean을 가져올 경우");		
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeansClass.class);
		
		Test t2 = ctx2.getBean(Test.class);
		t.m1();
		
		ctx.close();

	}
}
