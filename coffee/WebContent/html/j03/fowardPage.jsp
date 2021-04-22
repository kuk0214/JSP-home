<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<%
	RequestDispatcher rd = request.getRequestDispatcher("requestPage.jsp");
	try {
		rd.forward(request, response);
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
	<div class="w3-content mxw600 w3-center">
		<h1 class="w3-padding w3-deep-purple">여기는 포워드 페이지</h1>
	</div>
</body>
</html>