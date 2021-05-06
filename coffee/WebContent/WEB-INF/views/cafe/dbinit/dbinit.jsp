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
<style type="text/css">

</style>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="w3-content w3-center mxw600 w3-margin-top">
<c:if test="${not empty MSG}">
		<h1>테이블 생성에 성공했습니다</h1>
</c:if>
<c:if test="${empty MSG}">
		<h1>테이블 생성에 실패했습니다</h1>
</c:if>
	</div>
</body>
</html>