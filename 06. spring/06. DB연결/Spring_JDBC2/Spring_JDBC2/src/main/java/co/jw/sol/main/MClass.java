package co.jw.sol.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.jw.sol.beans.JBean;
import co.jw.sol.config.BBean;
import co.jw.sol.db.JdbcDAO;

public class MClass {
	public static void main(String args[]) {
		
	AnnotationConfigApplicationContext ctx=
			new AnnotationConfigApplicationContext(BBean.class);
	
	JdbcDAO dao=ctx.getBean(JdbcDAO.class);
	
	JBean b1=new JBean();
	b1.setNum1(2);
	b1.setStr1("인성");
	dao.in_sert(b1);
	
	JBean b2=new JBean();
	b2.setNum1(2);
	b2.setStr1("송이");
	dao.up_date(b2);
	
	//dao.de_lete(2);
	
	
	List<JBean> li=dao.sel_ect();
	
	for(JBean b3:li) {
		System.out.println(b3.getNum1());
		System.out.println(b3.getStr1());
	}
	ctx.close();
	}
}










