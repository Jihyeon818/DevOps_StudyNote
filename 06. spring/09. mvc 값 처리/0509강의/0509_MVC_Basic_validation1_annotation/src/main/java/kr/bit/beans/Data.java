package kr.bit.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class Data {
	
	@Max(100) // max : 최대값. (num1의 최대값이 100이라는 뜻으로, 100을 넘어가면 유효성 검사를 통과 못한다.)
	private int num1;
	
	@Size(min = 4, max = 10) // size : 글자 수. (num2 글자 수가 최소 4개, 최대 10개여야 한다)
	private String num2;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	

}
