<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
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

</script>
</head>
<body>
<%
	ArrayList<String> list = new ArrayList<String>();
	
	list.add("w3-red");
	list.add("w3-pink");
	list.add("w3-purple");
	list.add("w3-deep-purple");
	list.add("w3-blue");
	list.add("w3-cyan");
	list.add("w3-aqua");
	list.add("w3-green");
	list.add("w3-light-green");
	list.add("w3-lime");
	list.add("w3-yellow");
	list.add("w3-amber");
	list.add("w3-orange");
	list.add("w3-deep-orange");
	list.add("w3-black");
	list.add("w3-dark-grey");
	list.add("w3-grey");
	list.add("w3-light-grey");
	list.add("w3-blue-grey");
	list.add("w3-brown");
	list.add("w3-pale-red");
	list.add("w3-sand");
	list.add("w3-pale-yellow");
	list.add("w3-khaki");
	list.add("w3-pale-blue");
	list.add("w3-light-blue");
	
	request.setAttribute("LIST", list);
%>
<!-- 구구단 5단을 출력하세요. -->
<%--
	구구단을 출력하세요.
 --%>
	<div class="w3-content w3-center w3-margin-top">
<c:forEach var="dan" begin="2" end="9" varStatus="st">
		<div class="inblock w3-border w3-card-4 w3-margin">
			<h1 class="w3-col ${LIST.get(st.index)} w3-border-bottom" style="margin: 0px;">${dan} 단</h1>
			<div class="w3-col w3-padding">
		<c:forEach var="i" begin="1" end="9">
				<h3>${dan} X ${i} = ${1 * i}</h3>
		</c:forEach>
			</div>
		</div>
</c:forEach>
	</div>
<%--
	문제 2.
	구구단을 5단을 제외하고 출력하세요.
 --%>
 	<div class="w3-content w3-center w3-margin-top">
<c:forEach var="dan" begin="2" end="9" varStatus="st">
<c:if test="${dan ne 5}">
		<div class="inblock w3-border w3-card-4 w3-margin">
			<h1 class="w3-col ${LIST.get(st.index)} w3-border-bottom" style="margin: 0px;">${dan} 단</h1>
			<div class="w3-col w3-padding">
		<c:forEach var="i" begin="1" end="9">
				<h3>${dan} X ${i} = ${1 * i}</h3>
		</c:forEach>
			</div>
		</div>
</c:if>
</c:forEach>
	</div>
</body>
</html>