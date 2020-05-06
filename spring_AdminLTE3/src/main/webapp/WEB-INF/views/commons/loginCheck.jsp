<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	if(window.opener){		
		alert("세션이 만료되었거나 로그인하지 않았습니다.\n로그인화면으로 이동합니다.");
		window.close();
		window.opener.location.href="<%=request.getContextPath() %>/commons/loginForm.do";
	} else {
		location.href="<%=request.getContextPath() %>/commons/loginForm.do";
	}
</script>