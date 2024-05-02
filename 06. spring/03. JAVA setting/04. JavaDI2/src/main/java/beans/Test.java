package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Test {

	private int d1;
	private Data d2;
	
	@Autowired //자동 주입 (타입을 통해 bean 객체를 자동으로 주입)
	private Data d3;
	
	@Autowired
	@Qualifier("obj1") //autowire로 주할 때 같은 타입 bean이 여러개 정의되어있다면 이름을 설정해 주입
	private Data2 d4;
	
	@Autowired
	@Qualifier("obj2")
	private Data2 d5;

	public int getD1() {
		return d1;
	}

	public void setD1(int d1) {
		this.d1 = d1;
	}

	public Data getD2() {
		return d2;
	}

	public void setD2(Data d2) {
		this.d2 = d2;
	}

	public Data getD3() {
		return d3;
	}

	public void setD3(Data d3) {
		this.d3 = d3;
	}

	public Data2 getD4() {
		return d4;
	}

	public void setD4(Data2 d4) {
		this.d4 = d4;
	}

	public Data2 getD5() {
		return d5;
	}

	public void setD5(Data2 d5) {
		this.d5 = d5;
	}
}
