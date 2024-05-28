package kr.bit.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.beans.User;
import kr.bit.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Resource(name="loginBean") //RootAppContext의 세션영역세 설정한 빈 이름(loginBean)이 같기 때문에 주소값 자동 주입
	private User loginBean;
	
	public boolean existId(String user_id) {
		String user_name = userDao.existId(user_id);
		if(user_name == null) {
			return true; //중복되는 아이디가 없는경우
		}
		return false;
	}
	
	public void addUser(User joinBean){
		userDao.addUser(joinBean);
	}
	
	public void getLoginUser(User loginProBean) {
		User loginProBean2 = userDao.getLoginUser(loginProBean);
		if(loginProBean2!=null) {
			//비번, 아이디가 일치하면(로그인 된 상태라면)
			//세션영역에 저장한 loginBean 객체로부터 idx,name, 로그인 여부확인을 설정할 거임
			loginBean.setUser_idx(loginProBean2.getUser_idx()); //로그인 되어있는 사람의 idx값을 가져와서 User 클래스의 필드(user_idx)에 세팅
			loginBean.setUser_name(loginProBean2.getUser_name());
			loginBean.setUserLogin(true); //로그인 되어있는 상태이므로 true
		}
	}
	
	public void getModifyUser(User modifyBean) {
		User user = userDao.getModifyUser(loginBean.getUser_idx()); //로그인한 사람의 idx 기준으로 아이디, 이름 추출
		
		modifyBean.setUser_id(user.getUser_id());
		modifyBean.setUser_name(user.getUser_name());
		modifyBean.setUser_idx(user.getUser_idx());
	}
	
	public void modifyUser(User modifyBean) {
		modifyBean.setUser_idx(loginBean.getUser_idx());
		userDao.modifyUser(modifyBean);  //update	
	}
}
