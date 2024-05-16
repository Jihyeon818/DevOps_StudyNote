package kr.bit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.bit.beans.BoardInfo;
import kr.bit.mapper.TopMenuMapper;

@Repository //DB테이블에 접근하는 메서드들을 사용하기 위한 어노테이션
public class TopMenuDao {

	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public List<BoardInfo> getTopMenuList(){
		List<BoardInfo> topMenuList = topMenuMapper.getTopMenuList();
		return topMenuList; //1, 2, 1팀, 2팀
	}
	
}
