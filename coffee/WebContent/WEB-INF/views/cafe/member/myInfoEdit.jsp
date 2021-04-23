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
	label {
		font-size: 12pt;
	}
	
	.avtimg {
		width: 100px;
		height: 100px;
	}
	.avtbox {
		display: inline-block;
		width: 102px;
		height: 117px;
	}
	
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#cbtn').click(function() {
			$(location).attr('href', '/cafe/main.cafe');
		});
		$('[src="/cafe/img/avatar/${DATA.avatar}"]').parent().next().attr('checked', 'checked');
	});
</script>
</head>
<body>
	<div class="w3-content mxw650 w3-center">
		<h1 class="w3-padding w3-card-4 mgt20 w3-green">내 정보 수정</h1>
		
		<div id="frm">
			<div class="w3-col w3-margin-top w3-card-4 w3-padding w3-round-large">
				<div class="w3-col pdt10 w3-margin-top">
					<label class="w3-col m3 w3-rigth-align w3-text-grey">회원번호 : </label>
					<span id="mno" class="w3-col m8 mgl20 pdl20">${DATA.mno}</span>
				</div>
				<div class="w3-col pdt10 w3-margin-top">
					<label class="w3-col m3 w3-rigth-align w3-text-grey">회원이름 : </label>
					<span id="name" class="w3-col m8 mgl20 pdl20">${DATA.name}</span>
				</div>
				<div class="w3-col w3-margin-top">
					<label class="w3-col m3 w3-rigth-align w3-text-grey">아 이 디 : </label>
					<span id="id" class="w3-col m8 mgl20 pdl20">${DATA.id}</span>
				</div>
				<div class="w3-col w3-margin-top">
					<label class="w3-col m3 w3-rigth-align w3-text-grey">비밀번호 : </label>
					<input id="pw" class="w3-col m8 mgl20 pdl20">
				</div>
				<div class="w3-col w3-margin-top">
					<label class="w3-col m3 w3-rigth-align w3-text-grey">비번확인 : </label>
					<input id="repw" class="w3-col m8 mgl20 pdl20">
				</div>
				<div class="w3-col pdt10 w3-margin-top">
					<label class="w3-col m3 w3-rigth-align w3-text-grey">메일주소 : </label>
					<input id="mail" class="w3-col m8 mgl20 pdl20" placeholder="${DATA.mail}">
				</div>
				<div class="w3-col pdt10 w3-margin-top">
					<label class="w3-col m3 w3-rigth-align w3-text-grey">전화번호 : </label>
					<input id="tel" class="w3-col m8 mgl20 pdl20" placeholder="${DATA.tel}">
				</div>
				<div class="w3-col w3-margin-top">
					<label class="w3-col m3 w3-rigth-align w3-text-grey">회원성별 : </label>
					<span id="gen" class="w3-col m8 mgl20 pdl20">${DATA.gen}</span>
				</div>
				<div class="w3-col w3-margin-top" id="avtfr">
				<label class="w3-col m3 w3-rigth-align w3-text-grey">아 바 타 : </label>
				<div class="w3-col s8 mgl10 mgb10 w3-center">
			<c:if test="${(DATA.gen eq '남자') or (DATA.gen eq '남성')}">		
						<div class="avtboxfr w3-center w3-margin-top" id="mavt">
					<c:forEach var="idx" begin="1" end="3">
						 	<div class="avtbox">
						 		<label for="mavt${idx}">
						 			<img src="/cafe/img/avatar/img_avatar${idx}.png" class="w3-col avtimg">
						 		</label>
						 		<input type="radio" name="avt" id="mavt${idx}" value="${idx}">
						 	</div>
				 	</c:forEach>
						 </div>
			</c:if>
			<c:if test="${(DATA.gen eq '여자') or (DATA.gen eq '여성')}">
						 <div class="avtboxfr w3-center w3-margin-top" id="favt">
					<c:forEach var="idx" begin="4" end="6">
						 	<div class="avtbox">
						 		<label for="favt${idx}">
						 			<img src="/cafe/img/avatar/img_avatar${idx}.png" class="w3-col avtimg">
						 		</label>
						 		<input type="radio" name="avt" id="favt${idx}" value="${idx}">
						 	</div>
				 	</c:forEach>
				 		</div>
	 		</c:if>
				</div>
			</div>
			</div>
		</div>

		<div class="w3-col w3-margin-top w3-card-4 showFr">
			<div class="w3-half w3-padding w3-green w3-button" id="cbtn">취소</div>
			<div class="w3-half w3-padding w3-blue w3-hover-aqua w3-button" id="sbtn">확인</div>
		</div>		
	</div>
</body>
</html>