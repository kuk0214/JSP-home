<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cafe/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/user.css">
<script type="text/javascript" src="/cafe/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/cafe/js/w3color.js"></script>
</head>
<body>
<%--	
	String url = "requestPage.jsp?id=" + request.getParameter("id") + "&pw=" + request.getParameter("pw");
	response.sendRedirect(url);
--%>
	<%-- taglib를 사용해서 처리하는 방법 --%>
	<c:redirect url="requestPage.jsp">
		<c:param name="id" value="${param.id}"></c:param>
		<c:param name="pw" value="${param.pw}"></c:param>
		<c:param name="nick" value="kieun"></c:param>
	</c:redirect>
	
<%-- form 태그를 이용해서 처리하는 방법 --%>
<form method="post" action="requestPage.jsp" id="frm" name="frm">
	<input type="hidden" name="id" value='<%= request.getParameter("id") %>'>
	<input type="hidden" name="pw" value='<%= request.getParameter("pw") %>'>
</form>

	<div class="w3-content mxw600 w3-center">
		<h1 class="w3-padding w3-green">여기는 리다이렉트 페이지</h1>
	</div>
<%--
<script type="text/javascript">
//	location.href = 'requestPage.jsp?id=<%= request.getParameter("id") %>&pw=<%= request.getParameter("pw") %>';
</script>
 --%>
</body>
</html>