<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert('게시글이 수정되었습니다.');
	history.go(-1);
	window.opener.location.href = "/board/list.do";
</script>