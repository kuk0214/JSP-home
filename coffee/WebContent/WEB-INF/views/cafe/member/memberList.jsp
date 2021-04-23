<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cafe/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/w3-colors-flat.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/user.css">
<script type="text/javascript" src="/cafe/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/cafe/js/w3color.js"></script>
<style type="text/css"></style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#hbtn').click(function() {
			$(location).attr('href', '/cafe/main.cafe');
		});
	});
</script>
</head>
<body>
	<div class="w3-content mxw700 w3-center w3-margin-top">
		<h1 class="w3-green w3-margin-top w3-margin-bottom w3-card-4 w3-round-large">회원 리스트</h1>
		<div class="w3-col w3-card-4 w3-round-large w3-padding w3-margin-bottom">
			<div class="w3-col w3-margin-top w3-flat-turquoise w3-border w3-border-teal">
				<div class="w3-col m2 w3-border-right w3-border-teal">회원번호</div>
				<div class="w3-col m3 w3-border-right w3-border-teal">회원이름</div>
				<div class="w3-col m2 w3-border-right w3-border-teal">성별</div>
				<div class="w3-col m5">가 입 일</div>
			</div>
			
			<!-- 회원 리스트 -->
<c:forEach var="data" items="${LIST}" varStatus="st">
	<c:if test="${LIST.size() eq st.count}">
			<div class="w3-col w3-border-left w3-border-right w3-border-bottom w3-margin-bottom w3-border-teal">
	</c:if>
	<c:if test="${LIST.size() ne st.count}">
			<div class="w3-col w3-border-left w3-border-right w3-border-bottom w3-border-teal">
	</c:if>
				<div class="w3-col m2 w3-border-right w3-border-teal">${data.mno}</div>
				<div class="w3-col m3 w3-border-right w3-border-teal">${data.name}</div>
				<div class="w3-col m2 w3-border-right w3-border-teal">${data.gen}</div>
				<div class="w3-col m5">${data.sdate}</div>
			</div>
</c:forEach>
		</div>
		
		<div class="w3-col w3-margin-top w3-card-4 w3-button w3-blue w3-hover-aqua w3-round-large" id="hbtn">Home</div>
	</div>
</body>
</html>