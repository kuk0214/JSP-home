<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cafe/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/user.css">
<script type="text/javascript" src="/cafe/js/jquery-3.6.0.min.js"></script>
<style type="text/css">
	#fr {
		display: none;
	}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		// GET 방식으로 전송
		$('#btn1').click(function() {
			// 할일
			// 1. 데이터 유효성 검사
			var sid = $('#id').val();
			var spw = $('#pw').val();
			
			if(!(sid && spw)) {
				alert('필수 입력사항을 확인하세요!');
				return;
			}
			/* 
			// 1. form 태그로 전송하는 방법
			// form 태그로 전송할 예정이기 때문에
			// 필수속성을 완성해준다.
			$('#frm').attr('method', 'GET');
			$('#frm').attr('action', '/cafe/html/j03/getResult.jsp');
			// 폼태그를 전송한다.
			frm.submit();
			 */
			 
			 // 2. location 객체를 사용하는 방법
			 /* 
			 // 2-1. javascript로 처리하는 방법
			 location.href = '/cafe/html/j03/getResult.jsp?id=' + sid + '&pw=' + spw;
			  */
			 // 2-2. jquery로 처리하는 방법
			 $(location).attr('href', '/cafe/html/j03/getResult.jsp?id=' + sid + '&pw=' + spw);
		})
		
		// POST 방식으로 전송
		$('#btn2').click(function() {
			// 할일
			// 1. 데이터 유효성 검사
			var sid = $('#id').val();
			var spw = $('#pw').val();
			
			if(!(sid && spw)) {
				alert('필수 입력사항을 확인하세요!');
				return;
			}
			
			// 1. form 태그로 전송하는 방법
			// form 태그로 전송할 예정이기 때문에
			// 필수속성을 완성해준다.
			$('#frm').attr('method', 'POST');
			$('#frm').attr('action', '/cafe/html/j03/postResult.jsp');
			// 폼태그를 전송한다.
			frm.submit();
		})
	});
</script>
</head>
<body>
	<div class="w3-content mxw650 w3-center">
		<h1 class="w3-blue w3-padding w3-card-4 w3-round-large">Login</h1>
		
		<form name="frm" id="frm">
			<div class="w3-col w3-margin-top w3-card-4 w3-padding w3-round-large">
				<div class="w3-col w3-margin-top">
					<label for="id" class="w3-col m3 w3-right-align w3-text-grey">아이디 : </label>
					<input type="text" name="id" id="id" class="w3-col m8 mgl20">
				</div>
				<div class="w3-col pdt10 w3-margin-bottom">
					<label for="pw" class="w3-col m3 w3-right-align w3-text-grey">비밀번호 : </label>
					<input type="password" name="pw" id="pw" class="w3-col m8 mgl20">
				</div>
			</div>
		</form>
		
		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-half w3-padding w3-red w3-hover-orange " id="btn1">doGet</div>
			<div class="w3-half w3-padding w3-green w3-hover-lime " id="btn2">doPost</div>
		</div>
		
	</div>
</body>
</html>