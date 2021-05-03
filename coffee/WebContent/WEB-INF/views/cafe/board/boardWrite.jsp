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
		$('.w3-third').click(function() {
			var bid = $(this).attr('id');
			url = '';
			switch(bid){
			case 'hbtn':
				url = '/cafe/main.cafe';
				break;
			case 'rbtn':
				document.frm.reset();
				return;
			case 'sbtn':
				var title = $('#title').val().trim();
				var body = $('#body').val().trim();
				if(!(title && body)){
					alert('# 필수 입력사항을 확인하세요!');
					return;
				}
				$('#frm').submit();
				return;
			}
			$(location).attr('href', url);
		});
	});
</script>
</head>
<body>
	<div class="w3-content mxw700 w3-margin-top w3-padding">
		<h1 class="w3-purple w3-padding w3-center w3-card-4 w3-margin-top w3-margin-bottom">게시판 글 작성</h1>
		
		<!-- form 태그 -->
		<form method="POST" action="/cafe/board/boardWriteProc.cafe" name="frm" id="frm"
			class="w3-col w3-padding w3-margin-bottom w3-card-4 ">
			<div class="w3-col w3-margin-top pdb10 w3-border-bottom w3-border-light-grey">
				<label for="title" class="w3-col w150 w3-center w3-text-grey pdt5 ft14">글제목</label>
				<div class="w3-rest pdr30">
					<input type="text" name="title" id="title" class="w3-rest w3-input w3-round w3-border" placeholder="글제목 입력!">
				</div>
			</div>
			<div class="w3-col w3-margin-top pdb10 w3-border-bottom w3-border-light-grey">
				<label for="title" class="w3-col w150 w3-center w3-text-grey pdt5 ft14">첨부파일</label>
				<div class="w3-rest pdr30">
					<input type="file" name="file1" id="file1" class="w3-rest w3-input w3-round w3-border file">
				</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom pdb10 w3-border-bottom w3-border-light-grey">
				<label for="body" class="w3-col w150 w3-center w3-text-grey pdt5 ft14">글내용</label>
				<div class="w3-rest pdr30">
					<textarea name="body" id="body" rows="7" 
							class="w3-rest w3-input w3-round w3-border noresize" placeholder="글내용 입력!"></textarea>
				</div>
			</div>
		</form>
		
		<!-- 버튼 태그 -->
		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-third w3-green w3-hover-lime w3-button" id="hbtn">home</div>
			<div class="w3-third w3-blue w3-hover-pink w3-button" id="rbtn">reset</div>
			<div class="w3-third w3-orange w3-hover-red w3-button" id="sbtn">submit</div>
		</div>
	</div>
</body>
</html>