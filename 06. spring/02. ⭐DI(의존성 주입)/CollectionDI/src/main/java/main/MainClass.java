package main;

import java.util.List;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Data;
import beans.Test;

public class MainClass {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");

		Test t1 = ctx.getBean("test1", Test.class);
		
		List<String> li = t1.getList1();
		for(String str:li) {
			System.out.println(str);
		}
		
		List<Integer> li2 = t1.getList2();
		for(Integer str:li2) {
			System.out.println(str);
		}
		
		List<Data> li3 = t1.getList3();
		for(Data str:li3) {
			System.out.println(str);
		}
		
		System.out.println("---------set interface---------");
		
		Set<String> se1 = t1.getSet1();
		for(String str:se1) {
			System.out.println(str);
		}
		
		Set<Integer> se2 = t1.getSet2();
		for(Integer str:se2) {
			System.out.println(str);
		}
		
		Set<Data> se3 = t1.getSet3();
		for(Data str:se3) {
			System.out.println(str);
		}
		
		ctx.close();
		
	}
}


