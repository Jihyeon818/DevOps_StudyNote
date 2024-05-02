package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import beans.Test;
import beans.Test2;
import beans.Test3;
import beans.Test4;

public class MainClass {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");

		/*Test t1 = ctx.getBean("test1",Test.class);
		System.out.println(t1);*/
		
		/*Test2 t2 = ctx.getBean("test2",Test2.class);
		System.out.println(t2);*/
		
		/*Test3 t3 = ctx.getBean("test3",Test3.class);
		System.out.println(t3);*/ 
		
		Test3 t4 = ctx.getBean("test4",Test4.class);
		System.out.println(t4);
		//메소드가 없는 경우(default-init-method="default_init" default-destroy-method="default_destroy") 오류남
		
		ctx.close();
		
	}
}


