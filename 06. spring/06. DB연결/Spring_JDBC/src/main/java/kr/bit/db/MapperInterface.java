package kr.bit.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.aspectj.apache.bcel.classfile.ConstantInvokeDynamic;

import kr.bit.beans.JBean;

public interface MapperInterface {

	@Select("select num1, str1 from spring_table") //괄호안에 쿼리문을 넣으면 됨
	List<JBean> read();
	
	@Insert("insert into spring_table(num1,str1) values (#{num1}, #{str1})") //JDBC는 변수 ? / MyBatis는 #
	void in(JBean bean);
	
	@Update("update spring_table set str1=#{str1} where num1=#{num1}")
	void up(JBean bean);
	
	@Delete("delete from spring_table where num1=#{num1}")
	void del(int num1);

}
