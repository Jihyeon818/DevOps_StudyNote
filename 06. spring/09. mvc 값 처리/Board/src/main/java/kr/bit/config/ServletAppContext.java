package kr.bit.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.bit.beans.User;
import kr.bit.intercepter.LoginInterceptor;
import kr.bit.intercepter.TopInterceptor;
import kr.bit.mapper.BoardMapper;
import kr.bit.mapper.TopMenuMapper;
import kr.bit.mapper.UserMapper;
import kr.bit.service.TopMenuService;

@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.controller")
@ComponentScan("kr.bit.dao")
@ComponentScan("kr.bit.service")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer{//servlet-context.xml과 동일	
	@Value("${db.classname}")
    private String db_classname;

    @Value("${db.url}")
    private String db_url;
    
    @Value("${db.username}")
    private String db_username;
    
    @Value("${db.password}")
    private String db_password;
    
    @Autowired
    private TopMenuService topMenuService; //@service
    
    
    @Resource(name="loginBean")
    private User loginBean; //로그인 여부에 따라 상단메뉴바가 다르게 보이도록 하기 위해 주입받음
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) { 
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp"); //접두사, 접미사 재정의
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	@Bean //Bean으로 정보 등록
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

    //Mapper가 3개이므로 3개 다 Bean 등록 해줘야 함
    
    @Bean
    public MapperFactoryBean<BoardMapper> board_mapper(SqlSessionFactory factory) throws Exception{
        MapperFactoryBean<BoardMapper> fac = new MapperFactoryBean<BoardMapper> (BoardMapper.class);
        fac.setSqlSessionFactory(factory);
        return fac;
    }
    
    @Bean
    public MapperFactoryBean<TopMenuMapper> top_mapper(SqlSessionFactory factory) throws Exception{
        MapperFactoryBean<TopMenuMapper> fac = new MapperFactoryBean<TopMenuMapper> (TopMenuMapper.class);
        fac.setSqlSessionFactory(factory);
        return fac;
    }
    
    @Bean
    public MapperFactoryBean<UserMapper> user_mapper(SqlSessionFactory factory) throws Exception{
        MapperFactoryBean<UserMapper> fac = new MapperFactoryBean<UserMapper> (UserMapper.class);
        fac.setSqlSessionFactory(factory);
        return fac;
    }
    
    //인터셉터 등록
    public void addInterceptors(InterceptorRegistry re) {
    	 WebMvcConfigurer.super.addInterceptors(re);
    	 
    	 //TopInterceptor 등록
    	 TopInterceptor top = new TopInterceptor(topMenuService, loginBean);
    	 InterceptorRegistration re1 = re.addInterceptor(top); //topMenuInterceptor 등록
    	 re1.addPathPatterns("/**"); //모든 경로로 매핑해도 끌 수 있도록 컨트롤러 전에 preHamdle
    	 
    	 //LoginInterceptor 등록
    	 LoginInterceptor login = new LoginInterceptor(loginBean);
    	 InterceptorRegistration re2 = re.addInterceptor(login);
    	 //아래 3개 주소로 들어가기 전에 로그인 여부를 알아내서 로그인이 안돼있다면(LoginInterceptor에서 판단) 해당 주소로 못들어가고 user/not_login으로 강제이동
    	 //LoginInterceptor에서 로그인이 되어있어서 true값을 받았으면 해당 주소로 이동
    	 re2.addPathPatterns("/user/modify","user/logout","/board/*");
    	 re2.excludePathPatterns("/board/main"); //위 주소와 상관없이(로그인 여부X) 이동 가능
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySouresPlaceholderCofigurer() {
    	return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
    	ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
    	
    	res.setBasename("/WEB-INF/properties/error");
    	return res;
    }
}
