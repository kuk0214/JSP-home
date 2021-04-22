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
<style type="text/css">
	h1 {
		margin: 0px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		for(i = 0 ; i < 9 ; i++ ) {
			$('h1').eq(i).addClass(w3color[i]);
		}
	});
</script>
</head>
<body>
	<!-- 구구단을 출력하세요. -->
	<div class="w3-content w3-center w3-margin-top">
	<%
		for(int i = 2 ; i < 10 ; i++ ) {
	%>
		<div class="inblock w3-border w3-card-4 w3-margin">
			<h1 class="w3-col "><%= i %> 단</h1>
			<div class="w3-col w3-padding">
		<%
				for(int j = 0 ; j < 9 ; j++ ) {					
		%>
				<h3><%= i %> X <%= j+1 %> = <%= i * (j + 1) %></h3>
		<%
				}
		%>
			</div>
		</div>
	<%
		}
	%>
	</div>
</body>
</html>