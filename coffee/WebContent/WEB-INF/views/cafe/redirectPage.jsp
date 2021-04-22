<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/cafe/js/jquery-3.6.0.min.js"></script>
<%--
	이 페이지는 리다이렉트용 페이지
 --%>
 
<%-- 로그인 실패 리다이렉트 처리 --%>
<c:if test="${not empty LOGINMSG}">
<script type="text/javascript">
	$(document).ready(function() {
		$('#frm').attr('action', '/cafe/member/login.cafe');
		$('#frm').append('<input type="hidden" name="msg" value="${LOGINMSG}">');
		$('#frm').submit();
	});
</script>
</c:if>

<%-- 회원가입 실패 리다이렉트 처리 --%>
<c:if test="${not empty JOINMSG}">
<script type="text/javascript">
	$(document).ready(function() {
		$('#frm').attr('action', '/cafe/member/join.cafe');
		$('#frm').append('<input type="hidden" name="msg" value="${JOINMSG}">');
		$('#frm').submit();
	});
</script>
</c:if>
</head>
<body>
	<form method="post" name="frm" id="frm"></form>
</body>
</html>