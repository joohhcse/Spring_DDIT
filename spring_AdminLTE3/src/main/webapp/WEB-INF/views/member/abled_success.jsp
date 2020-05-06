<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("${id}를 활성화시켰습니다.");
	location.href="/member/detail.do?id=${id}"
</script>