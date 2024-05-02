<%@page import="java.beans.beancontext.BeanContext"%>
<%@page import="bean.BoardBean"%>
<%@page import="java.util.Vector"%>
<%@page import="bean.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
	<link rel="stylesheet" href="BoardStyle.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
<h1>게시판 목록</h1>
<%
	int pageSize = 10;
	String pageNum=request.getParameter("pageNum");
	if(pageNum==null){
		pageNum="1";
	}

	int count=0; //전체 게시글 개수 알아내기 위해
	int number=0;
	
	BoardDAO bdao = new BoardDAO();
	count = bdao.getAllCount(); //전체 게시글 개수 읽어오기, 페이지 네이션을 위해

	int currentPage=Integer.parseInt(pageNum); //현재 페이지 인덱스 번호
	int startRow=(currentPage-1)*pageSize+1;
			//현재 11페이지 일 때 (11-1)*10+1
	int endRow = currentPage*pageSize; //1*10
	
	Vector<BoardBean> vec = bdao.allBoard(startRow,endRow);
	number=count-(currentPage-1)*pageSize;
%>

<table width="800">
	<thead>
		<tr height="40">
			<th width="50">번호</th>
			<th width="420">제목</th>
			<th width="100">작성자</th>
			<th width="150">작성날짜</th>
			<th width="80">조회수</th>
		</tr>
	</thead>
	<tbody>
	<%
		for(int i=0;i<vec.size();i++){
			BoardBean bean = vec.get(i); //백터에 있는 정보 꺼내와서 BoardBean에 저장
	%>
	<tr height="40">
		<td width="50"><%=number-- %></td> <!-- 최신글이 가장 크고 줄어들어야하니 num-- 줄어듬! -->
		<td width="420" class="title">
			<a href="BoardIn.jsp?num=<%=bean.getNum()%>">
			
				<%
					if(bean.getRe_step()>1){ //댓글이 달렸을 시
						for(int j=0;j<(bean.getRe_step()-1)*5;j++){//원글 기준 4개의 빈 공백
				%>			&nbsp;
				<%
						}
				%>	<i class="bi bi-arrow-return-right"></i>
				<%
					}
				%>
				<%=bean.getSubject() %> <!-- 브라우저에 출력되는 제목 -->
			</a>
		</td>
		<td width="100"><%=bean.getWriter() %></td>
		<td width="150"><%=bean.getReg_date() %></td>
		<td width="80"><%=bean.getReadcount() %></td>
	</tr>	
	<%
		}
	%>
	<tr height="40" class="lasttr">
		<td colspan="5">
			<input type="button" value="글작성" onclick="location.href='BoardForm.jsp'">
		</td>
	</tr>
	</tbody>
</table>


<!-- 페이지네이션 -->
<%
	if(count>0){ //총 게시글이 127개면 127/10+(127%10) → 12페이지 + 1페이지(7개 남는 1페이지)  = 총 페이지 수 13페이지
		int pageCount=count/pageSize+(count%pageSize==0? 0: 1); //총 페이지 수
		
		int startPage=1;
		
		if(currentPage%10!=0){ //currentPage가 11일때, 페이지가 한자리 수면 시작번호 1(1~10번)
			startPage = (int)(currentPage/10)*10+1; //11, 10페이지 넘어가 다음 10페이지를 보일때 시작 페이지 수(11~20번)
		}else{ //currentPage가 10일때
			startPage = ((int)(currentPage/10)-1)*10+1;
		}
		
		int pageBlock=10; //10p씩 보임
		
		int endPage=startPage+pageBlock-1;
		
		if(endPage>pageCount){
			endPage=pageCount;
		}
		
		//'이전'링크 제공(10페이지 초과인 경우만 나타남)
		if(startPage>10){
%>
		<a href="BoardList.jsp?pageNum=<%=startPage-10 %>">[이전]</a>
		<!-- 이전버튼 누르면 이전 범위의 첫번째 페이지로 이동함 -->
<%
		}
		for(int i=startPage;i<=endPage;i++){
%>
		<!-- 10개의 번호 출력 -->
		<a href="BoardList.jsp?pageNum=<%=i%>">[<%=i%>]</a>
<%			
		}
		if(endPage<pageCount){
%>
			<a href="BoardList.jsp?pageNum=<%=startPage+10 %>">[다음]</a>
			<!-- 다음버튼 누르면 다음 범위의 첫번째 페이지로 이동함 -->
<%
		}
	}
%>


</body>
</html>