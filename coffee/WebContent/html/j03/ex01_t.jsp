<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cafe/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/user.css">
</head>
<body>
<!-- 구구단 5단을 출력하세요. -->
	<div class="w3-content mxw600 w3-center w3-margin-top">
		<div class="inblock w250 w3-border w3-card-4">
			<h1 class="w3-col w3-deep-orange w3-border-bottom" style="margin: 0px;">5 단</h1>
			<div class="w3-col w3-padding">
		<%
				for(int i = 0 ; i < 9 ; i++ ) {					
		%>
				<h3>5 X <%= i+1 %> = <%= 5 * (i + 1) %></h3>
		<%
				}
		%>
			</div>
		</div>
	</div>
</body>
</html>