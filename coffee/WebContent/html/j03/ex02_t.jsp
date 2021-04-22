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

</style>
<script type="text/javascript">
	$(document).ready(function(){
		var el = $('.inblock > h1');
		for(l = 0 ; l < el.length ; l++ ){
			$(el).eq(l).addClass(w3color[l]);
		}
	});
</script>
</head>
<body>
	<!-- 구구단을 출력하세요. -->
	<div class="w3-content mxw700 w3-center w3-margin-top">
	<%
		for(int dan = 2 ; dan < 10 ; dan++ ){
	%>
		<div class="inblock w150 mgl10 w3-border w3-card-4">
			<h1 class="w3-col w3-border-bottom" style="margin: 0px;"><%= dan %> 단</h1>
			<div class="w3-col w3-padding">
		<%
				for(int i = 0 ; i < 9 ; i++ ){
		%>
				<h4><%= dan %> x <%= i+1 %> = <%= dan * (i + 1) %></h4>
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