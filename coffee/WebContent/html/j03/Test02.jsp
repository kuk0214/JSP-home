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
<%!
	String name = "김기은";

	public String getName() {
		return name;
	}
%>
	<div class="w3-content mxw600 w3-center">
		<h2 class="w3-blue"><%= name %></h2>
		<h2 class="w3-indigo"><%= getName() %></h2>
	</div>
</body>
</html>