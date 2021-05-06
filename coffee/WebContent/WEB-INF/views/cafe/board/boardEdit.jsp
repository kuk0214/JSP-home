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
	label.ft14 {
		line-height: 200%;
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#lbtn').click(function() {
			$('#frm').attr('action', 'boardDetail.cafe');
			$('#frm').submit();
		});
		
		$('#rbtn').click(function() {
			document.frm.reset();
		});
		
		$('#ebtn').click(function() {
			$('#frm').submit();
		});
	});
</script>
</head>
<body>

	<div class="w3-content mxw700 w3-margin-top w3-padding">
		<h1 class="w3-purple w3-padding w3-center w3-card-4 w3-margin-top w3-margin-bottom">${DATA.id} 님 글 수정하기</h1>
		<!-- form 태그 -->
		<form method="POST" action="/cafe/board/boardEditProc.cafe" id="frm" name="frm" 
				class="w3-col w3-padding w3-margin-bottom w3-card-4 ">
			<input type="hidden" name="nowPage" id="nowPage" value="${nowPage}">
			<input type="hidden" name="bno" id="bno" value="${DATA.bno}">
			<div class="w3-col w3-margin-top pdb10 w3-border-bottom w3-border-light-grey">
				<label for="title" class="w3-col w150 w3-center w3-text-grey pdt5 ft14">글제목</label>
				<div class="w3-rest pdr30">
					<input class="w3-rest w3-input w3-round w3-border" value="${DATA.title}">
				</div>
			</div>
			<div class="w3-col w3-margin-top pdb10 w3-border-bottom w3-border-light-grey">
				<label class="w3-col w150 w3-center w3-text-grey pdt5 ft14">첨부파일</label>
				<div class="w3-rest pdr30">
					<div class="w3-col w3-margin-top w3-center pdAll10">
			<c:if test="${empty LIST}">
				첨부파일 없음
			</c:if>
			<c:forEach var="data" items="${LIST}">
						<div class="inblock box120 pdAll10 mgl10 w3-border w3-border-grey w3-card">
							<div class="w3-col imgBox100"> 
								<img class="w3-col img100" src="/cafe/img/upload/${data.savename}">
							</div>
						</div>
			</c:forEach>						
					</div>
				</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom pdb10 w3-border-bottom w3-border-light-grey">
				<label for="body" class="w3-col w150 w3-center w3-text-grey pdt5 ft14">글내용</label>
				<div class="w3-rest pdr30">
					<textarea name="body" id="body" rows="7" 
						class="w3-rest w3-input w3-round w3-border noresize">${DATA.body}</textarea>
				</div>
			</div>
		</form>
		
		<!-- 버튼 태그 -->
		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-third w3-green w3-hover-lime w3-button" id="lbtn">원글보기</div>
			<div class="w3-third w3-blue w3-hover-pink w3-button" id="rbtn">리셋</div>
			<div class="w3-third w3-orange w3-hover-red w3-button" id="ebtn">수정</div>
		</div>
	</div>
</body>
</html>