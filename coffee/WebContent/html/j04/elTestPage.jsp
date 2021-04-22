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
<c:set var="name" value="김기은"></c:set>
<script type="text/javascript">
	alert('name : ${name}');

	var name = '${name}';
<%--
	if (name) {
		<c:remove var="name" />
	}
	--%>
</script>
</head>
<body>
	<c:if test="${not empty name}">
	<div class="w3-content mxw600 w3-center">
		<h1 class="w3-blue w3-margin-top">name : ${name}</h1>
	</div>
	</c:if>
</body>
</html>