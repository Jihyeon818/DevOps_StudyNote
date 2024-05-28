package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.bit.beans.BoardInfo;

public interface TopMenuMapper {
	@Select("select board_info_idx, board_info_name from board_info_table order by board_info_idx")
	List<BoardInfo> getTopMenuList();
	//함수호출 시 위 커리문 실행 → 쿼리문 결과값들이 List에 저장됨
	//인터페이스라 여기서 메서드 작성 불가능!
}
