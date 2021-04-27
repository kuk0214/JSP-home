<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cafe/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/user.css">
<script type="text/javascript" src="/cafe/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/cafe/js/w3color.js"></script>
<style type="text/css"></style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#hbtn').click(function() {
			$(location).attr('href', '/cafe/main.cafe');
		});
		
		$('#wbtn').click(function() {
			document.frm.submit();
		});
	});
</script>
</head>
<body>
	<div class="w3-content mxw650 w3-maring-top">
		<header class="w3-col w3-card-4 mgb20">
			<h1 class="w3-green w3-center w3-padding mg0">방명록 작성</h1>
		<nav class="w3-bar w3-pale-yellow">
			<div class="w3-col w150 w3-left w3-button w3-amber" id="hbtn">home</div>
<c:if test="${not empty SID}">
	<c:if test="${CNT == 0}">
			<div class="w3-col w150 w3-left w3-button w3-light-green w3-right" id="wbtn">글작성</div>
	</c:if>
			<div class="w3-col w150 w3-left w3-button w3-lime w3-right" id="outbtn">logout</div>
</c:if>
<c:if test="${empty SID}">
			<div class="w3-col w150 w3-left w3-button w3-deep-orange w3-right" id="lbtn">login</div>
			<div class="w3-col w150 w3-left w3-button w3-yellow w3-right" id="jbtn">join</div>
</c:if>
		</nav>
		</header>
		
<c:forEach var="data" items="${LIST}">
		<div class="w3-col w3-round-large w3-card-4 w3-margin-bottom">
			<div class="w3-col box120 pdAll10 w3-border-right">
				<img src="/cafe/img/avatar/${data.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
			</div>
			<div class="w3-rest w3-padding">
				<div class="w3-col w3-border-bottom">
					<span class="w3-text-left mgb10 ft10"><b>${data.id}</b></span>
					<span class="w3-right mgb10 ft10">${data.sdate}</span>
				</div>
				<div class="w3-col w3-margin-top">
					<span class="w3-col w3-padding ft12">${data.body}</span>
				</div>
			</div>
		</div>
</c:forEach>

<%--
		<div class="w3-col w3-margin-top">
			<div class="w3-col m2 w3-button w3-green w3-card-4" id="hbtn">Home</div>
			<div class="w3-col m2 w3-button w3-blue w3-right w3-card-4" id="wbtn">Write</div>
		</div>
 --%>
	</div>
</body>
</html>