package kr.bit.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.bit.entity.Member;

@Mapper
/*
 * 피피티에도 있는 내용이지만...
 * MyBatis 에서는 select 가 성공하면 조회한 값을 반환하고,
 * insert, update, delete 의 경우, 성공하면 int 1, 실패하면 int 0 을 반환한다.
 */
public interface MemberMapper {

	public Member registerCheck(String memberID);
	
	public int register(Member member);
	
	public Member memberLogin(Member memberVo);
	
	public int memberUpdate(Member memberVo);
	
	public Member getMember(String memberID);
	
	public void memberProfileUpdate(Member memberVo); //id기준으로 사진 변경
}
