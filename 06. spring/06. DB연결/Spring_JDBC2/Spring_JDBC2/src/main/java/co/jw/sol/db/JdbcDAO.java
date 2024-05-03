package co.jw.sol.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.jw.sol.beans.JBean;

@Component
public class JdbcDAO {

	//JDBC 관리를 해주는 객체를 주입받고 있다. (BBean.java에서 돌려받은 객체의 주소값을
	// db에 넣고있다 -> 타입 기준)
	@Autowired
	private JdbcTemplate db;
	
	//MapperClass 자동주입
	@Autowired
	private MapperClass mapper;
	
	
	public void in_sert(JBean bean) {
		String sql="insert into spring_table(num1,str1) values(?,?)";
		db.update(sql,bean.getNum1(),bean.getStr1());
	}
	
	public List<JBean> sel_ect(){
		String sql="select num1,str1 from spring_table";
		List<JBean> li=db.query(sql,mapper); 
		//아까 테이블로 부터 값을 꺼내서 bean에 저장한것 반환받음
		return li;
	}
	
	public void up_date(JBean bean) {
		String sql="update spring_table set str1=? where num1=?";
		db.update(sql, bean.getStr1(), bean.getNum1());
	}
	
	public void de_lete(int n) {
		String sql="delete from spring_table where num1=?";
		db.update(sql, n);
	}

	
	
}
