package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.beans.BoardInfo;
import kr.bit.dao.TopMenuDao;

@Service
public class TopMenuService {
	
	@Autowired
	private TopMenuDao topMenuDao;
	
	public List<BoardInfo> getTopMenuList(){
		List<BoardInfo> topMenuList = topMenuDao.getTopMenuList();
		return topMenuList;  //1,2,1팀,2팀
	}
}
//상단메뉴에 팀명을 띄우고 싶음(상단메뉴는 어떤주소를 눌러도 다 동작해야하기 때문에 - 뭘 요청하던간에 인터셉터를 거쳐야함)
//뭘 요청하던간에 topmenu통과해야한다
