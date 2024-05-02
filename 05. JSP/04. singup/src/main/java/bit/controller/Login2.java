package bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bit.dao.MemberDAO;
import bit.dto.MemberBean;

@WebServlet("/Login2.do")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
		dis.forward(request, response);	
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login.jsp";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDAO mdao = MemberDAO.getInstance();
		int result = mdao.userCheck(userid, pwd);
		
		if(result==1) { //로그인 성공
			MemberBean mbean = mdao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loguser", mbean);
			request.setAttribute("msg", "로그인 성공");
			url = "main.jsp";
		}else if (result==0) { //비밀번호 불일치
			request.setAttribute("msg", "비밀번호가 틀렸습니다");
		}else if (result==-1) { //회원정보 없음
			request.setAttribute("msg", "아이디가 존재하지 않습니다");
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response); 
	}

}
