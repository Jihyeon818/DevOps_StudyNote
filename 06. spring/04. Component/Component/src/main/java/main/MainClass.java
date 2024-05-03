package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Test;
import beans.Test2;
import beans2.Test3;
import beans2.Test4;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		
		Test t1 = ctx.getBean(Test.class);
		System.out.println(t1);
		
		Test2 t2 = ctx.getBean("test2",Test2.class);
		System.out.println(t2);
		
		Test2 t22 = ctx.getBean("test22",Test2.class);
		System.out.println(t22); //다른 id의 객체라 test2와 주소값이 다름
		
		Test3 t3 = ctx.getBean(Test3.class);
		System.out.println(t3);
		
		Test4 t4 = ctx.getBean("component4",Test4.class); //이름을 성정한 경우 id값이 됨
		System.out.println(t4);
		
		Test4 t44 = ctx.getBean("test4",Test4.class); //컴포넌트로 등록 후 bean으로 따로 설정도 가능
		System.out.println(t44);
		
		//java에 등록한 bean 가져오기
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext("config/BeanClass");
		
		Test tt1 = ctx2.getBean(Test.class); 
		System.out.println(tt1);
		
		
		ctx.close();
	}
}


