package kr.bit.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;

import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.bit.beans.User;

public class UserValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		String beanName = errors.getObjectName();
		
		//join.jsp의 폼에 데이터 입력
		// modelAttribute로 User 클래스의 필드에 데이터 값이 저장되어 있는 상태(값 주입된 상태)
		
		if(beanName.equals("joinBean")||beanName.equals("modifyBean")) {
			if(user.getUser_pw().equals(user.getUser_pw2())==false) {
				errors.rejectValue("user_pw", "NotEqual");
				errors.rejectValue("user_pw2", "NotEqual");
			}
		}
		//비밀번호와 비밀번호 확인이 같아야 됨. 유효성검사하는 어노테이션이 따로 없음 → 개발자가 정의(커스터 마이징)
		
		if(beanName.equals("joinBean")) {
			if(user.isExistId()==false) {
				errors.rejectValue("user_id", "NotCheck");
			}
		}
	}
}
