<%@page import="mgr.MemberMgr"%>
<%@ page import="bean.MemberBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>로그인 처리</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");

%>
<jsp:useBean id="mbean" class="bean.MemberBean">
    <jsp:setProperty property="*" name="mbean"/>
</jsp:useBean>
<%
    mbean.setId(id);
    mbean.setPwd(pwd);
    MemberMgr mgr = new MemberMgr();
    int loginResult = mgr.loginCheck(id, pwd);

    if(loginResult == 1) {
        // 로그인한 회원의 정보를 세션에 담음
        MemberBean loginMember = mgr.findMember(id);
        session.setAttribute("loginMember", loginMember);

        response.sendRedirect("main.jsp");
    }else {
%>
        <script>
            alert("아이디 혹은 비밀번호가 일치하지 않습니다");
        </script>
<%
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>