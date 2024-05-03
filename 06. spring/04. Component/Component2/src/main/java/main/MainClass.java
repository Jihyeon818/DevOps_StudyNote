package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Test;
import beans.Test2;

public class MainClass {
	public static void main(String[] args) {
		//java에 등록한 bean 가져오기
	   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(config.BeanClass.class);

	    Test t1 = ctx.getBean(Test.class);
	    System.out.println(t1);
	    
	    Test2 t2 = ctx.getBean("component2", Test2.class);
	    System.out.println(t2);
	    
	    ctx.close();
	}
}


