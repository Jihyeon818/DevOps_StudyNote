package beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Test {
	@Autowired
	private Data d1;
	
	@Autowired
	@Qualifier("component2")
	private Data2 d2;
	
	@Resource(name="component3")
	private Data3 d3;
	
	@Resource(name="component4") //Data3에 해당 이름이 없으므로 BeanClass에서 등록해줘야 함
	private Data3 d4;
	
	@Resource(name="component5")
	private Data3 d5;

	public Data getD1() {
		return d1;
	}

	public void setD1(Data d1) {
		this.d1 = d1;
	}

	public Data2 getD2() {
		return d2;
	}

	public void setD2(Data2 d2) {
		this.d2 = d2;
	}

	public Data3 getD3() {
		return d3;
	}

	public void setD3(Data3 d3) {
		this.d3 = d3;
	}

	public Data3 getD4() {
		return d4;
	}

	public void setD4(Data3 d4) {
		this.d4 = d4;
	}

	public Data3 getD5() {
		return d5;
	}

	public void setD5(Data3 d5) {
		this.d5 = d5;
	}	
}
