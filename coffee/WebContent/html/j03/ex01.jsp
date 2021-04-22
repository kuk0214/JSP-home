<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cafe/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/user.css">
<script type="text/javascript" src="/cafe/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/cafe/js/w3color.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		for(var j = 0 ; j < 9 ; j++ ) {
			$('h1').addClass(w3color[j]);
		}
	});
</script>
</head>
<body>
<!-- 구구단 5단을 출력하세요. -->
	<%
		int dan = 5;
		int i;
	%>
	<div class="w3-content mxw600 w3-center">
	<%
		for(i = 1 ; i < 10 ; i++ ) {	
	%>
		<h1 class="w250 w3-border w3-padding w3-card-4 w3-margin-bottom"><%= dan %> X <%= i %> = <%= dan * i %> </h1>
	<%
		}
	%>
	</div>
</body>
</html>