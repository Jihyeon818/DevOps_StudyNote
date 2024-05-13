package kr.bit.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.bit.database.MapperInterface;

@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.controller")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer{
	
	@Value("${db.classname}")
	private String db_classname;

	@Value("${db.url}")
	private String db_url;
	
	@Value("${db.username}")
	private String db_username;
	
	@Value("${db.password}")
	private String db_password;
	
	
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);
		
		return source;
	}
	
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception{
		SqlSessionFactoryBean fac = new SqlSessionFactoryBean();
		fac.setDataSource(source);
		SqlSessionFactory factory = fac.getObject();
		return factory;
	}
	
	@Bean
	public MapperFactoryBean<MapperInterface> text_mapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<MapperInterface> fac = new MapperFactoryBean<MapperInterface> (MapperInterface.class);
		fac.setSqlSessionFactory(factory);
		return fac;
	}
	
/*	@Bean(name = "messageSource")
	//bean 이름을 설정해줘야 에러가 안난다.
	public ReloadableResourceBundleMessageSource source() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
	    res.setBasename("/WEB-INF/properties/error");
	      
	    return res;
	} */
	
}
