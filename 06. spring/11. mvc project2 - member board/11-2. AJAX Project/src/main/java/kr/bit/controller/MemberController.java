package kr.bit.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.bit.entity.Member;
import kr.bit.mapper.MemberMapper;

@Controller
public class MemberController {

	@Autowired
	MemberMapper memberMapper;  
	
	@RequestMapping("/memberJoin")
	public String memberJoin() {
		return "member/join";
	}
	
	@RequestMapping("/memberLoginForm")
	public String memberLoginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping("/memberLogout")
	public String memberLogout(HttpSession session) {
		session.invalidate(); //세션 무효화시키는 작업. 세션 영역에 담은 데이터들이 사라진다.
		return "redirect:/";  //무효화 이후 홈으로 보낸다.
	}
	
	@RequestMapping("/memberUpdateForm")
	public String memberUpdateForm() {
		return "member/updateForm";
	}
	
	@RequestMapping("/memberImageForm")
	public String memberImageForm() {
		return "member/imageForm";
	}
	
	@RequestMapping("/memberImageUpdate")
	public String memberImageUpdate(HttpServletRequest request, HttpSession session, RedirectAttributes rttr) throws IOException{
		MultipartRequest multi=null;
		int maxSize=40*1024*1024;
		String savePath=request.getRealPath("resources/upload");
				
		multi=new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String memberID=multi.getParameter("memberID"); //클라이언트에서 넘긴 memberID값 받음
		String newProfile=""; 
		
		File file = multi.getFile("memberProfile"); //input type file의 name 값을 가져와 파일을 가져옴
		
		if(file!=null) {					//lastIndexOf로 .을 찾아 뒤에 글자 찾기 = 확장자
			String str=file.getName().substring(file.getName().lastIndexOf(".")+1);
			str=str.toUpperCase();  //확장자를 대문자(toUpperCase)로 바꿈
			
			if(str.equals("PNG") || str.equals("GIF") || str.equals("JPG")) {
				String origin = memberMapper.getMember(memberID).getMemberProfile();
									//resource/upload/.../.../  사진이 들어있는 하위경로
				File file1 = new File(savePath+"/"+origin);
				
				//프로필을 이미 등록했는데 또 등록하는 경우
				if(file1.exists()) {
					file1.delete();
				}
				newProfile=file.getName(); //기존 파일을 삭제하고 새로운 사진 등록
			}else { //이미지 확장자가 아니라면
				if(file.exists()) {
					file.delete();
				}
				rttr.addFlashAttribute("msg1","실패");
				rttr.addFlashAttribute("msg2","이미지 파일만 업로드할 수 있습니다");
				
				return "redirect:/memberImageForm";
			}
		}
		Member member = new Member();
		member.setMemberID(memberID);
		member.setMemberProfile(newProfile);
		memberMapper.memberProfileUpdate(member); //id기준으로 사진 업데이트
		
		Member m = memberMapper.getMember(memberID); //id기준 회원정보를 가져옴
		session.setAttribute("memberVo", m);
		rttr.addFlashAttribute("msg1","성공");
		rttr.addFlashAttribute("msg2","이미지가 업로드 되었습니다");
		
		return "redirect:/"; //메인으로 이동
	}
	
	@RequestMapping("/memberRegisterCheck")   //ajax에서 넘긴 id값을 주입받음
	public @ResponseBody int memberRegisterCheck(@RequestParam("memberID") String memberID) {
		
		Member m=memberMapper.registerCheck(memberID);
		
		if(m!=null || memberID.equals("")) {
			return 0;
		}
		return 1;
	}
	
	//member 필드에 있는 값들은 객체에 자동주입되지만 memberPw1, memberPw2은 member필드에 없기 때문에 따로 파라미터로 받아줬다.
	@RequestMapping("/memberRegister")
	public String memberRegister(@ModelAttribute Member member, String memberPw1, String memberPw2, 
			RedirectAttributes rttr, HttpSession session) {
	 	
		//유효성 검사 - 아래 항목들이 전부 공백이면 모달창에 에러 메시지를 띄울 것이다.
		if(member.getMemberID().equals("") || memberPw1.equals("") || memberPw2.equals("") || 
				member.getMemberName().equals("") || member.getMemberGender().equals("") || member.getMemberEmail().equals("")) {
			/*
			 * redirect 로 전송 시 request 영역의 데이터는 사라져버린다. 이럴 때는 RedirectAttributes 에 데이터를 담아서 보내면 되는데,
			 * RedirectAttributes 의 addAttribute 메서드를 사용해서 데이터를 담아서 보내면 된다. (영역은 request와 같이 유지됨)
			 * 그런데 지금 예시처럼 에러메세지를 담아서 보내고 싶은 경우, 일회성으로 사용되는 데이터이기 때문에...
			 * 이럴때는 addFlashAttribute 를 사용한다. 여기 담긴 값들은 새로고침하면 휘발되어 없어진다.
			 */
			
			rttr.addFlashAttribute("msg1","회원가입 실패.");
			rttr.addFlashAttribute("msg2","모든 값을 입력해주세요.");
			
			return "redirect:/memberJoin";
		}
		
		//유효성 검사 - 비밀번호 틀린경우 모달창에 에러메시지 
		if(!memberPw1.equals(memberPw2)) {
			rttr.addFlashAttribute("msg1", "비밀번호 불일치.");
			rttr.addFlashAttribute("msg2", "비밀번호를 다시 입력해주세요.");
			
			return "redirect:/memberJoin";
		}
		
		//위 유효성 검사가 문제 없으면 DB에 삽입.
		int result = memberMapper.register(member);
		//다른 필드는 다 member객체에 들어가 있는데, profile 필드에만 값이 없어서 주입이 안될듯하다고 한줄 추가하라고 함. 
		member.setMemberProfile("");
		
		if(result == 1) { //insert 성공하면 1을 반환함.
			rttr.addFlashAttribute("msg1", "회원가입 성공");
			rttr.addFlashAttribute("msg2", "회원가입이 완료되었습니다.");
			
			//회원정보를 세션 영역에 담아준다. (request영역에 담으면 유지가 안됨)
			session.setAttribute("memberVo", member);
	
			return "redirect:/";
		} else {
			rttr.addFlashAttribute("msg1", "회원가입 실패");
			rttr.addFlashAttribute("msg2", "회원가입에 실패했습니다.");
			
			return "redirect:/memberJoin";
		}
		
	}
	
	@RequestMapping("/memberLogin")
	public String memberLogin(Member member, RedirectAttributes rttr, HttpSession session) {
		
		//유효성 검사 - 아이디, 비밀번호 안 적었을 경우 모달창에 에러메시지 띄움.
		if(member.getMemberID().equals("") || member.getMemberPw().equals("")) {
			rttr.addFlashAttribute("msg1", "로그인 실패");
			rttr.addFlashAttribute("msg2", "아이디 또는 비밀번호를 입력해주세요.");
			
			return "redirect:/memberLoginForm";
		}
		
		//유효성 검사에서 문제가 없으면 로그인 함수 호출.
		//id 와 pw 가 일치할 경우 회원정보를 끌어온다.
		Member memberVo = memberMapper.memberLogin(member);

		if(memberVo != null) { //로그인 성공
			rttr.addFlashAttribute("msg1", "로그인 성공");
			rttr.addFlashAttribute("msg2", "로그인되었습니다.");
			
			session.setAttribute("memberVo", memberVo);
			
			return "redirect:/";
		} else { //로그인 실패
			rttr.addFlashAttribute("msg1", "로그인 실패");
			rttr.addFlashAttribute("msg2", "아이디 또는 비밀번호를 다시 입력해주세요.");
			
			return "redirect:/memberLoginForm";
		}
		
	}
	
	@RequestMapping("/memberUpdate")
	public String memberUpdate(Member member, String memberPw1, String memberPw2, RedirectAttributes rttr, HttpSession session) {
		
		//유효성 검사 - 아래 항목들이 전부 공백이면 모달창에 에러 메시지를 띄울 것이다.
		if(member.getMemberID().equals("") || memberPw1.equals("") || memberPw2.equals("") || 
				member.getMemberName().equals("") || member.getMemberGender().equals("") || member.getMemberEmail().equals("")) {
			
			rttr.addFlashAttribute("msg1", "Error.");
			rttr.addFlashAttribute("msg2", "모든 값을 입력해주세요.");
			
			return "redirect:/memberUpdateForm";
		}
		
		//유효성 검사 - 비밀번호 틀린경우 모달창에 에러메시지 
		if(!memberPw1.equals(memberPw2)) {
			rttr.addFlashAttribute("msg1", "비밀번호 불일치.");
			rttr.addFlashAttribute("msg2", "비밀번호를 다시 입력해주세요.");
			
			return "redirect:/memberUpdateForm";
		}
		
		int result = memberMapper.memberUpdate(member);
		if(result == 0) {
			rttr.addFlashAttribute("msg1", "Error");
			rttr.addFlashAttribute("msg2", "회원정보를 다시 입력해주세요.");
			
			return "redirect:/memberUpdateForm";
		} else {
			rttr.addFlashAttribute("msg1", "회원정보 수정 완료");
			rttr.addFlashAttribute("msg2", "회원정보를 수정했습니다.");
			
			session.setAttribute("memberVo", member);
			
			return "redirect:/";
		}
		
	}
	
}
