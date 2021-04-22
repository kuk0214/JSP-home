<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cafe/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/user.css">
</head>
<body>
	<%
		String name = "김기은";
		int age = 20;
	%>
	<div class="w3-content mxw600 w3-center">
	<%
		for(int i = 0 ; i < 5 ; i++ ) {
			
	%>
		<h1 class="w3-blue">이름 : <%= name %></h1>
		<h1 class="w3-blue">나이 : <%= age %></h1>
	<%
		}
	%>
	</div>
</body>
</html>