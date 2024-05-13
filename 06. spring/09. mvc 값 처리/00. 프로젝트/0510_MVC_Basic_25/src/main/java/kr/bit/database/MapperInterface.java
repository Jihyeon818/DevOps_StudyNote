package kr.bit.database;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.bit.beans.Data;

public interface MapperInterface {

	@Insert("Insert into mvc_table(num1,num2,num3) values(#{num1},#{num2},#{num3})") 
	void insert_data(Data data);
	
	@Select("select num1, num2, num3 from mvc_table")
	List<Data> select_data();

}
