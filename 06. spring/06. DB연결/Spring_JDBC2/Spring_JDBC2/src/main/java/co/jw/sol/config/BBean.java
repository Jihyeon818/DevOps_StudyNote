package co.jw.sol.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"co.jw.sol.beans", "co.jw.sol.db"})
public class BBean {
	
	@Bean
	public BasicDataSource source() {
		
		BasicDataSource source=new BasicDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/hyeon");
		source.setUsername("root");
		source.setPassword("1234");
		
		return source;	
	}
	
	//DB에 접속해 쿼리를 전달하는 빈을 등록해야함
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		JdbcTemplate db=new JdbcTemplate(source);
		return db;
	}

}








