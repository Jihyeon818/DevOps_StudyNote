<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<script>
	alert('게시글이 작성되었습니다')
	location.href="${root}board/read?board_info_idx=${writeBean.content_board_idx}&content_idx=${writeBean.content_idx}"
</script>