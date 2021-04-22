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
		// forward 방식으로 요청
		$('#fbtn').click(function() {
			// 할일
			// 데이터 유효성 검사하고
			if(!inputCk()) {
				return;
			}
			// 페이지 요청하고 ==> action 속성을 정확하게 작성한다.
//			$(document.frm).attr('action', 'forwardPage.jsp');
			$('#frm').attr('action', ' forwardPage.jsp');
			// 폼을 전송한다.
			$('#frm').submit();
			
		});
		
		// redirect 방식으로 요청
		$('#rbtn').click(function() {
			// 할일
			// 데이터 유효성 검사하고
			if(!inputCk()) {
				return;
			}
			// 페이지 요청하고 ==> action 속성을 정확하게 작성한다.
//			$(document.frm).attr('action', 'forwardPage.jsp');
			$('#frm').attr('action', ' redirectPage.jsp');
			// 폼을 전송한다.
			$('#frm').submit();
		});
		
		function inputCk() {
			// 할일
			// 데이터 유효성 검사하고
			var sid = $(document.frm.id).val();
			var spw = $(document.frm.pw).val();
			
			var result = true;
			
			if(!(sid && spw)) {
				alert('필수입력사항을 확인하세요!');
				result = false;
			}
			
			return result;
		}
	});
</script>
</head>
<body>
	<div class="w3-content mxw650 w3-center">
		<h1 class="w3-blue w3-padding w3-card-4 w3-round-large">Login</h1>
		
		<form method="post" name="frm" id="frm">
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
			<div class="w3-half w3-padding w3-red w3-hover-orange " id="fbtn">forward</div>
			<div class="w3-half w3-padding w3-green w3-hover-lime " id="rbtn">redirect</div>
		</div>
		
	</div>
</body>
</html>