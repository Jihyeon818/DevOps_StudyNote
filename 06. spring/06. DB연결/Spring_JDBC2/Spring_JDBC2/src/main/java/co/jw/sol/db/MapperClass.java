package co.jw.sol.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import co.jw.sol.beans.JBean;

@Component
public class MapperClass implements RowMapper<JBean>  {

	public JBean mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		JBean bean=new JBean();
		
		bean.setNum1(rs.getInt("num1"));
		bean.setStr1(rs.getString("str1"));
		
		return bean;
		
	}
	
}
