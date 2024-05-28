package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.bit.entity.Member;
import kr.bit.entity.MemberAuth;
import kr.bit.entity.MemberUser;
import kr.bit.mapper.MemberMapper;
import kr.bit.security.MemberUserDetailsService;

@Controller
public class MemberController {

	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	PasswordEncoder	passwordEncoder;
	
	@Autowired
	MemberUserDetailsService memberUserDetailsService;

	@RequestMapping("/memberJoin")
	public String memberJoin() {
		return "member/join";
	}

	@RequestMapping("/memberRegisterCheck") // ajax에서 넘긴 id값을 주입받음
	public @ResponseBody int memberRegisterCheck(@RequestParam("memberID") String memberID) {

		Member m = memberMapper.registerCheck(memberID);

		if (m != null || memberID.equals("")) {
			return 0;
		}
		return 1;
	}

	@RequestMapping("/memberRegister")
	public String memberRegister(Member member, String memberPw1, String memberPw2, RedirectAttributes rttr,
			HttpSession session) {

		if (member.getMemberID().equals("") || memberPw1.equals("") || memberPw2.equals("")
				|| member.getMemberName().equals("") || member.getMemberGender().equals("")
				|| member.getMemberEmail().equals("") || member.getAuthLi().size()==0) {

			rttr.addFlashAttribute("msg1", "실패");
			rttr.addFlashAttribute("msg2", "입력해주세요");

			return "redirect:/memberJoin";
		}

		if (!memberPw1.equals(memberPw2)) {
			rttr.addFlashAttribute("msg1", "실패");
			rttr.addFlashAttribute("msg2", "비밀번호가 다릅니다");

			return "redirect:/memberJoin";
		}
		
		//회원가입 시 비밀번호 암호화
		String enPw=passwordEncoder.encode(member.getMemberPw());
		member.setMemberPw(enPw); //암호화된 비번 셋팅
		
		int result = memberMapper.register(member); // db에 회원정보 삽입
		member.setMemberProfile("");
		
		if (result == 1) { // 1행 추가됨-> insert 성공 되면
			//회원권한을 저장해야함
			List<MemberAuth> list=member.getAuthLi();
			for(MemberAuth mem : list) {
				if(mem.getAuth()!=null) {
					MemberAuth memberAuth=new MemberAuth();
					memberAuth.setMemberID(member.getMemberID());
					memberAuth.setAuth(mem.getAuth());
					memberMapper.authInsert(memberAuth);
				}
			}
			rttr.addFlashAttribute("msg1", "성공");
			rttr.addFlashAttribute("msg2", "회원가입에 성공했습니다");
			
			/*
			//회원정보(member_security)+권한정보(member_auth).. 값을 다 가져옴
			Member memberVo = memberMapper.getMember(member.getMemberID());
			System.out.println(memberVo); //회원가입하면 회원가입 정보가 콘솔창에 뜨도록

			session.setAttribute("memberVo", memberVo);

			return "redirect:/";*/
			return "redirect:memberLoginForm";
			
		} else {
			rttr.addFlashAttribute("msg1", "실패");
			rttr.addFlashAttribute("msg2", "회원가입에 실패했습니다");

			return "redirect:memberJoin/";
		}
	}

	@RequestMapping("/memberLoginForm")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}

	@RequestMapping("/memberLogout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	/* 시큐리티에서 처리함
	@RequestMapping("/memberLogin")
	public String memberLogin(Member member, RedirectAttributes rttr, HttpSession session) {

		if (member.getMemberID().equals("") || member.getMemberPw().equals("")) {

			rttr.addFlashAttribute("msg1", "실패");
			rttr.addFlashAttribute("msg2", "아이디나 비밀번호를 입력하세요");

			return "redirect:memberLoginForm/";
		}

		Member memberVo = memberMapper.memberLogin(member);
		// id와 pw가 일치할경우 회원정보들을 memberVo에 저장

		if (memberVo != null && passwordEncoder.matches(member.getMemberPw(), memberVo.getMemberPw())) {
			rttr.addFlashAttribute("msg1", "성공");
			rttr.addFlashAttribute("msg2", "로그인 되었습니다");

			session.setAttribute("memberVo", memberVo);

			return "redirect:/";
		} else {

			rttr.addFlashAttribute("msg1", "실패");
			rttr.addFlashAttribute("msg2", "아이디 또는 비밀번호를 다시 확인해주세요");
			return "redirect:memberLoginForm/";
		}
	}*/

	@RequestMapping("/memberUpdateForm")
	public String memberUpdateForm() {
		return "member/memberUpdateForm";
	}

	@RequestMapping("/memberUpdate") // 수정된 데이터들이 Member클래스의 객체의 필드에 각각담겨져있다!
	public String memberUpdate(Member member, String memberPw1, String memberPw2, RedirectAttributes rttr,
			HttpSession session) {

		if (member.getMemberID().equals("") || memberPw1.equals("") || memberPw2.equals("")
				|| member.getMemberName().equals("") || member.getMemberGender().equals("")
				|| member.getMemberEmail().equals("")) {

			rttr.addFlashAttribute("msg1", "실패");
			rttr.addFlashAttribute("msg2", "입력해주세요");

			return "redirect:/memberUpdateForm";
		}

		if (!memberPw1.equals(memberPw2)) {
			rttr.addFlashAttribute("msg1", "실패");
			rttr.addFlashAttribute("msg2", "비밀번호가 다릅니다");

			return "redirect:/memberUpdateForm";
		}
		
		String enPw=passwordEncoder.encode(member.getMemberPw());
		member.setMemberPw(enPw); 

		int result = memberMapper.memberUpdate(member);

		if (result == 1) {
			
			//회원정보 수정 시 기존 권한 삭제
			memberMapper.authDelete(member.getMemberID());
			
			//새로운 권한 저장
			List<MemberAuth> list=member.getAuthLi();
			for(MemberAuth mem : list) {
				if(mem.getAuth()!=null) {
					MemberAuth memberAuth=new MemberAuth();
					memberAuth.setMemberID(member.getMemberID());
					memberAuth.setAuth(mem.getAuth());
					memberMapper.authInsert(memberAuth);
				}
			}
			
			rttr.addFlashAttribute("msg1", "성공");
			rttr.addFlashAttribute("msg2", "회원 수정에 성공했습니다");

			/*
			//회원정보 수정을 한 후 다시 회원정보를 가져와서 세팅해줘야한다.
			//session에 담은 객체에 사진이 안담겨있는 상태이므로 
			Member memberVo=memberMapper.getMember(member.getMemberID());
			session.setAttribute("memberVo", memberVo);
			// 수정된 데이터들을 세션영역 memberVo에 담아서 redirect로 화면이동
			 */
			
			//→ 회원정보 변경 후 세션 재설정
			//SecurityContext에 들어있음
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			MemberUser memberUser = (MemberUser)authentication.getPrincipal();
			//Principal: "누구"에 해당하는 정보 → 객체 타입은 UserDetails: pw, id, auth
			SecurityContextHolder.getContext().setAuthentication(createAuth(authentication,memberUser.getMember().getMemberID()));

			return "redirect:/";
		} else { // 수정 실패했을 때
			rttr.addFlashAttribute("msg1", "실패");
			rttr.addFlashAttribute("msg2", "회원 수정에 실패했습니다");
			
			return "redirect:/memberUpdateForm";
		}
	}
	
	@RequestMapping("/memberImageForm")
	public String memberImageForm() {
		return "member/memberImageForm";
	}
	
	@RequestMapping("/memberImageUpdate")
	public String memberImageUpdate(HttpServletRequest request, HttpSession session,
			                        RedirectAttributes rttr) throws IOException {
		
		MultipartRequest multi=null;
		int maxSize=40*1024*1024;
		String savePath=request.getRealPath("resources/upload");
		
		try {
			multi=new MultipartRequest(request, savePath, maxSize, "UTF-8",
					                  new DefaultFileRenamePolicy());
		}
		catch(Exception e) {
			rttr.addFlashAttribute("msg1","실패");
			rttr.addFlashAttribute("msg2","파일크기 10MB 넘었다");
			return "redirect:/memberImageForm";
		}

		String memberID=multi.getParameter("memberID"); //클라이언트에서 넘김 memberID값 받음
		String newProfile=""; 
		
		File file=multi.getFile("memberProfile");  //input type file의 name값으로 파일가져옴
		
		if(file!=null) {
			String str=file.getName().substring(file.getName().lastIndexOf(".")+1); //확장자
			str=str.toUpperCase();
			
			if(str.equals("PNG") || str.equals("GIF") || str.equals("JPG")) {
				String origin=memberMapper.getMember(memberID).getMemberProfile();
				System.out.println(origin);
				                  //resources/upload/.../...
				File file1=new File(savePath+"/"+origin);
				
				if(file1.exists()) {
					file1.delete();
				}
				newProfile=file.getName();
				
			}
			else {
				if(file.exists()) {
				   file.delete();
				}
				rttr.addFlashAttribute("msg1", "실패");
				rttr.addFlashAttribute("msg2", "이미지 파일만 업로드할 수 있습니다");
				
				return "redirect:/memberImageForm";
			}
		}
		
		Member member=new Member();
		member.setMemberID(memberID);
		member.setMemberProfile(newProfile);
		memberMapper.memberProfileUpdate(member); //id기준으로 사진업데이트 됨
		
		/*Member m=memberMapper.getMember(memberID);
		session.setAttribute("memberVo", m);*/
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MemberUser memberUser = (MemberUser) authentication.getPrincipal();
		//principal: "누구"에 해당하는 정보 -> 객체타입은 UserDetails :pw,id,auth
		SecurityContextHolder.getContext().setAuthentication
		(createAuth(authentication,memberUser.getMember().getMemberID()));
		
		rttr.addFlashAttribute("msg1", "성공");
		rttr.addFlashAttribute("msg2", "업로드 되었습니다");
	
		return "redirect:/";
	}
	
	//새로운 세션 생성 메소드
	//UsernamePasswordAuthenticationToken에 회원 정보+권한 정보가 담겨있음
	protected Authentication createAuth(Authentication authentication, String username) {
		//UserDetails:업데이트 된 사용자 정보 조회 및 저장
		UserDetails userDetails=memberUserDetailsService.loadUserByUsername(username);		//				자격증명                         다시 사용자 권한 설정
		UsernamePasswordAuthenticationToken newAuth=new UsernamePasswordAuthenticationToken(userDetails, authentication.getCredentials(), userDetails.getAuthorities());
		return newAuth;
	}
	
	@GetMapping("/access-denied")
	public String access_denied(){
		return "access-denied";
	}
}