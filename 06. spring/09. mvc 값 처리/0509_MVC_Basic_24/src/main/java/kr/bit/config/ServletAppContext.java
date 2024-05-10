package kr.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.bit.interceptor.Inter1;
import kr.bit.interceptor.Inter2;
import kr.bit.interceptor.Inter3;
import kr.bit.interceptor.Inter4;
import kr.bit.interceptor.Inter5;
import kr.bit.interceptor.Inter6;
import kr.bit.interceptor.Inter7;
import kr.bit.interceptor.Inter8;

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
	//bean 이름을 설정해줘야 에러가 안난다.
	public ReloadableResourceBundleMessageSource source() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
	    res.setBasename("/WEB-INF/properties/error");
	      
	    return res;
	}
	
	//인터셉터 등록 - 경로와 인터셉터를 설정하기 위해
	public void addInterceptors(InterceptorRegistry reg) {
		WebMvcConfigurer.super.addInterceptors(reg);
		
		Inter1 i1 = new Inter1();
		Inter2 i2 = new Inter2();
		Inter3 i3 = new Inter3();
		Inter4 i4 = new Inter4();
		Inter5 i5 = new Inter5();
		Inter6 i6 = new Inter6();
		Inter7 i7 = new Inter7();
		Inter8 i8 = new Inter8();
		
		InterceptorRegistration r1 = reg.addInterceptor(i1);
		InterceptorRegistration r2 = reg.addInterceptor(i2);
		InterceptorRegistration r3 = reg.addInterceptor(i3);
		InterceptorRegistration r4 = reg.addInterceptor(i4);
		InterceptorRegistration r5 = reg.addInterceptor(i5);
		InterceptorRegistration r6 = reg.addInterceptor(i6);
		InterceptorRegistration r7 = reg.addInterceptor(i7);
		InterceptorRegistration r8 = reg.addInterceptor(i8);
		
		r1.addPathPatterns("/t1"); //interceptor가 가로채 갈 주소를 등록
		r2.addPathPatterns("/t1");
		r3.addPathPatterns("/t2");
		r4.addPathPatterns("/t1","/t2");
		
		r5.addPathPatterns("/s1/t3","/s1/t4");
		
		r6.addPathPatterns("/*");
		r7.addPathPatterns("/s1/*");
		r8.addPathPatterns("/**");
		r8.excludePathPatterns("/*"); //interceptor가 가로채가지 않을 주소를 등록
	}
}
