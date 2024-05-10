package kr.bit.vaildator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.bit.beans.Data;

public class DataValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// 유효성 검사할 데이터를 가지고 있는 객체가 유효성 검사가 가능한지 확인
		return Data.class.isAssignableFrom(clazz);
		//Data라는 클래스에 지정된 값 형식에 맞는 지 확인
	}
	@Override
	public void validate(Object target, Errors errors) {
		// 유효성 검사하는 메소드
		//Data에서 값 형식이 지정된건 num1뿐. 2,3은 여기서 유효성 검사 작성
		ValidationUtils.rejectIfEmpty(errors, "num2", "error2"); //num2가 empty면 에러 이름 error2
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "num3", "error3"); //num3가 empty이거나 whitespace면 에러 이름 error3
		
		Data d = (Data)target;
		
		String str1=d.getNum2();
		String str2=d.getNum3();
		
		if(str1.length()>5) { //num2 길이가 5 초과 시 error4라는 이름으로 에러 정의
			errors.rejectValue("num2", "error4"); //num2에 대한 유료성 검사 추가
		}
		
		if(str2.contains("-")==false) {
			errors.rejectValue("num3", "error5");
		}
		
	}

}
