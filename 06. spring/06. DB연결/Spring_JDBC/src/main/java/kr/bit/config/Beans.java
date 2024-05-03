package kr.bit.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.bit.db.MapperInterface;

@Configuration
@ComponentScan(basePackages = {"kr.bit.beans"})
public class Beans {
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/hyeon");
		source.setUsername("root");
		source.setPassword("1234");
		
		return source;
	}
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception{
		SqlSessionFactoryBean fac = new SqlSessionFactoryBean();
		fac.setDataSource(source);
		SqlSessionFactory fac2 = fac.getObject();
		return fac2;
	}
	
	@Bean
	public MapperFactoryBean<MapperInterface> test(SqlSessionFactory fac) throws Exception{
		MapperFactoryBean<MapperInterface> mapper = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
		mapper.setSqlSessionFactory(fac);
		return mapper;
	}
}
