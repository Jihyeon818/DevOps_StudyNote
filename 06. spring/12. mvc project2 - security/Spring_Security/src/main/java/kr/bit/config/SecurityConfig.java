package kr.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import kr.bit.security.MemberUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MemberUserDetailsService();
	}
	
	@Override //인증작업
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder()); //loadUserByUsername함수 실행
	}
;	
	//비밀번호 암호화 하기 위해 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //비밀번호를 암호하는데 사용할 수 있는 메서드를 가진 클래스
	}
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		//요청에 대한 보안 -> 한글깨짐 방지
		CharacterEncodingFilter filter=new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		security.addFilterBefore(filter, CsrfFilter.class);
		
		//요청에 따른 권한 확인하고 서비스하는 부분
		security
			.authorizeRequests() //시큐리티의 구성메서드 : 인가규칙 설정
				.antMatchers("/") //경로에 대한 인가설정 지정. 설정한 리소스 접근을 인증절차 없이 허용하겠다
				.permitAll() //해당 경로에 대한 모든 요청 인가 → 모든 사용자 접근허용ㅁ
				.and()
			.formLogin() //스프링에서 제공하는 폼이 기본으로 나옴(로그인처리 성공실패 처리 사용)
				.loginPage("/memberLoginForm") //사용자가 만든 로그인 페이지를 사용하려할 때 설정
				.loginProcessingUrl("/memberLogin") //이 url이 왔을 때 스프링 시큐리티 로그인으로 넘어가겠다(인증처리 필터)
				.permitAll()
				.and()
			.logout() //스프링에서 성정해놓은 logout을 거쳐 세션 끝나고
				.invalidateHttpSession(true) //세션제거
				.logoutSuccessUrl("/") //로그아웃 처리
				.and() //성공 처리 후 이동
			.exceptionHandling().accessDeniedPage("/access-denied"); //오류 페이지로 이동
	}
}
