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
<script type="text/javascript">
	$(document).ready(function() {
		// 그냥요청 이벤트 처리
		$('.w3-button').eq(0).click(function() {
			$(location).attr('href', 'requestPage.jsp');
		});
		
		// 리다이렉트 요청 이벤트 처리
		$('.w3-button').eq(1).click(function() {
			$(location).attr('href', 'redirectPage.jsp');
		});
	});
</script>
</head>
<body>
	<div class="w3-content mxw600 w3-center">
		<h1 class="w3-blue">리다이렉트 테스트</h1>
		<div class="w3-margin-top">
			<div class="w3-half w3-button w3-padding w3-blue">그냥요청</div>
			<div class="w3-half w3-button w3-padding w3-orange">리다이렉트 요청</div>
		</div>
	</div>
</body>
</html>