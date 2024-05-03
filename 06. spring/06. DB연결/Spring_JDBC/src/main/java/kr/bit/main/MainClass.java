package kr.bit.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.bit.beans.JBean;
import kr.bit.config.Beans;
import kr.bit.db.MapperInterface;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);

		MapperInterface m = ctx.getBean("test",MapperInterface.class);
		
		JBean b1 = new JBean();
		b1.setNum1(10);
		b1.setStr1("spring");
		m.in(b1);
		
		JBean b2 = new JBean();
		b2.setNum1(20);
		b2.setStr1("summer");
		m.up(b2);
		
		List<JBean> li = m.read();
		for(JBean j:li) {
			System.out.println(j.getNum1());
			System.out.println(j.getStr1());
		}
	}
}
