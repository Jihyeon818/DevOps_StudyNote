package kr.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.controller")
@ComponentScan("kr.bit.beans")
public class ServletAppContext implements WebMvcConfigurer{
	
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
	
	//properties 파일을 jsp(브라우저)에서 출력하기 위해서는 빈을 등록해야 한다.
	@Bean(name = "messageSource")
	//왠지 모르겠지만 bean 이름을 설정해줘야 에러가 안난다.
	public ReloadableResourceBundleMessageSource source() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
	    res.setBasenames("/WEB-INF/properties/data1", "/WEB-INF/properties/data2");
	      
	    return res;
	}
}
