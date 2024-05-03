package kr.bit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"kr.bit.advisor","kr.bit.beans"})
@EnableAspectJAutoProxy //xml에서 작성한 <aop:aspectj-autoproxy/>과 동일
public class BeansClass {

}
