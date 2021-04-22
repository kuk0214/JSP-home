<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET Result</title>
<link rel="stylesheet" type="text/css" href="/cafe/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/user.css">
<script type="text/javascript" src="/cafe/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/cafe/js/w3color.js"></script>
</head>
<body>
	<div class="w3-content mxw600 w3-center">
		<h1 class="w3-blue w3-card-4 w3-margin-bottom">Get Result</h1>
		<div class="w3-col w3-padding w3-card-4">
			<h3>아이디 : <%= request.getParameter("id") %></h3>
			<h3>비밀번호 : <%= request.getParameter("pw") %></h3>
		</div>
	</div>
</body>
</html>