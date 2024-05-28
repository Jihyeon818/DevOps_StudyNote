package kr.bit.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class MemberUser extends User{
	//인증을 하며 사용자 정보 저장
	private Member member;
	
	public MemberUser(String name, String password, Collection<? extends GrantedAuthority> autorities) {
		//부모 생성자 호출
		super(name, password, autorities); //3가지 정보
	}
	 
	public MemberUser(Member memberVo) { //memberLogin..
		super(memberVo.getMemberID(), memberVo.getMemberPw(), memberVo.getAuthLi().stream()
				.map(auth->new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
				//권한을 일렬로 나열하고자함. SimpleGrantedAuthority: 권한정보를 문자열로 나열
		//세가지 정보(시큐리티에서 제공)
		this.member=memberVo; //3가지 정보 외 member entity에 있는 정보들을 담음
	}
}
