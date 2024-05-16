package kr.bit.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.bit.beans.User;

public class LoginInterceptor implements HandlerInterceptor{
	private User loginBean;
	
	public LoginInterceptor(User loginBean) {
		this.loginBean = loginBean;
	}
	
	//로그인 여부에 따라 주소를 입력해도 못들어가도록 막는 작업
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { //pre: 주소를 들어가기 전에 비로그인 상태일 경우 주소 강제 이동
		
		if(loginBean.isUserLogin()==false) { //로그인 안됐으면
			String str = request.getContextPath(); //첫 경로 읽어내기
			
			response.sendRedirect(str+"/user/not_login"); //컨트롤러 맵핑 및 jsp 파일 만들어줘야 함
			return false;
		}
		return true;
	}
}
