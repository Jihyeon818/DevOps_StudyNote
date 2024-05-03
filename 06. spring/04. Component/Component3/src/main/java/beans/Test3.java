package beans;

import org.springframework.beans.factory.annotation.Value;

public class Test3 {

	private int d1;
	private String d2;
	private Data4 d3;
	private Data5 d4;
	
	public Test3(@Value("1") int d1, @Value("spring") String d2, Data4 d3, Data5 d4){
		this.d1=d1;
		this.d2=d2;
		this.d3=d3;
		this.d4=d4;
	}

	public int getD1() {
		return d1;
	}

	public void setD1(int d1) {
		this.d1 = d1;
	}

	public String getD2() {
		return d2;
	}

	public void setD2(String d2) {
		this.d2 = d2;
	}

	public Data4 getD3() {
		return d3;
	}

	public void setD3(Data4 d3) {
		this.d3 = d3;
	}

	public Data5 getD4() {
		return d4;
	}

	public void setD4(Data5 d4) {
		this.d4 = d4;
	}
	
	
}
