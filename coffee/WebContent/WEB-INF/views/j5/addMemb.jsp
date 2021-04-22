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
	
	.avtboxfr {
		padding: 10px;
	}
	
	.avtbox {
		display: inline-block;
		width: 102px;
		height: 117px;
	}
	
	#avtimg
</style>
<script type="text/javascript">
	$(document).ready(function() {
		// form 태그 action 속성 부여
		// 1. code 값 받아오고
		var scode = '${param.code}';
		
		if(scode == 'taglib') {
			$('#frm').attr('action', '/cafe/j05/memberInfo.cls')
		} else {
			$('#frm').attr('action', '/cafe/j05/memberInfo2.cls')
		}
		
		// 리셋버튼 이벤트 처리
		$('#rbtn').click(function() {
			document.frm.reset();
		});
		
		// 제출버튼 이벤트 처리
		$('#sbtn').click(function() {
			// 할일
			// 1. 입력된 내용 읽어오고
			var sid = $('#id').val();
			var sname = $('#name').val();
			var sgen = $('#gen :checked').val();
//			var savt = $('#avt :selected').val(); // select 태그로 처리하는 경우
			var savt = $('#avt :checked').val(); // radio 버튼으로 처리하는 경우
			
			// 2. 입력안된 내용이 있으면 돌려보내고
			if(!(sid && sname && sgen && savt)) {
				$('#id01').css('display', 'block');
				return;
			}
			// 3. 제출
			$('#frm').submit();
		});
		
		// 모달창 닫기 이벤트 처리
		$('.md1').click(function() {
			$('#id01').css('display', 'none');
		});
		
		$(document.frm.gen).change(function() {
			$('.show').removeClass('w3-hide');
			$('#gen').removeClass('w3-margin-bottom');
			var sgen = $(this).val();
			
			// select tag 의 내용 읽어오고
			/* if(sgen == 'M') {
				$('#avt').html('');
				
				// 기본 태그 채우고
				$('#avt').append('<option value=""># 아바타 선택</option');
				$('#avt').append('<option value="1">avatar1</option');
				$('#avt').append('<option value="2">avatar2</option');
				$('#avt').append('<option value="3">avatar3</option');
				
			} else if(sgen == 'F') {
				$('#avt').html('');
				
				// 기본 태그 채우고
				$('#avt').append('<option value=""># 아바타 선택</option');
				$('#avt').append('<option value="4">avatar4</option');
				$('#avt').append('<option value="5">avatar5</option');
				$('#avt').append('<option value="6">avatar6</option');
			} */
			
			if(sgen == 'M') {
				$('#mavt').css('display', 'block')
				$('#favt').css('display', 'none')
			} else if (sgen == 'F') {
				$('#mavt').css('display', 'none')
				$('#favt').css('display', 'block')
			}
		});
		
		/* $('#gen [value="M"]').click(function() {
			$('option').eq(1).css('display', 'block');
			$('option').eq(2).css('display', 'block');
			$('option').eq(3).css('display', 'block');
			$('option').eq(4).css('display', 'none');
			$('option').eq(5).css('display', 'none');
			$('option').eq(6).css('display', 'none');
		});
		
		$('#gen [value="F"]').click(function() {
			$('option').eq(1).css('display', 'none');
			$('option').eq(2).css('display', 'none');
			$('option').eq(3).css('display', 'none');
			$('option').eq(4).css('display', 'block');
			$('option').eq(5).css('display', 'block');
			$('option').eq(6).css('display', 'block');
		}); */
		
	});
</script>
</head>
<body>
	<div class="w3-content mxw650 w3-center">
		<h1 class="w3-padding w3-card-4 w3-margin-top w3-blue">회원정보</h1>
		<form method="post" name="frm" id="frm">
			<input type="hidden" name="code" value="${param.code}">
			<div class="w3-col w3-card-4 mgt20">
				<div class="w3-col w3-margin-top">
					<label for="name" class="w3-col m3 w3-rigth-align w3-text-grey">회원이름 : </label>
					<input type="text" id="name" name="name" class="w3-col m8 mgl20">
				</div>
				<div class="w3-col w3-margin-top">
					<label for="id" class="w3-col m3 w3-rigth-align w3-text-grey">아 이 디 : </label>
					<input type="text" id="id" name="id" class="w3-col m8 mgl20">
				</div>
				<div class="w3-col w3-margin-top w3-margin-bottom" id="gen">
					<label class="w3-col m3 w3-rigth-align w3-text-grey">회원성별 : </label>
					<div class="w3-col m8 mgl20">
						<div class="w3-half w3-center">
							<input type="radio" name="gen" value="M" class="w3-radio"> 
							<span>남자</span>
						</div>
						<div class="w3-half w3-center">
							<input type="radio" name="gen" value="F" class="w3-radio"> 
							<span>여자</span>
						</div>
					</div>
				</div>
				<div class="w3-col w3-margin-top w3-margin-bottom w3-hide show" id="avt">
					<label for="avt" class="w3-col m3 w3-rigth-align w3-text-grey">아 바 타 : </label>
					<!-- <select id="avt" name="avt" class="w3-col m8 mgl20 w3-select w3-border">
						<option value=""># 아바타 선택</option>
					</select> -->
					<div class="avtboxfr" id="mavt">
				<c:forEach var="idx" begin="1" end="3">
						<div class="avtbox">
						<label for="fav${idx}">
							<img src="/cafe/img/avatar/img_avatar${idx}.png" class="w3-col avtimg">
						</label>
							<input type="radio" name="avt" value="${idx}">
						</div>
				</c:forEach>
					</div>
					<div class="avtboxfr" id="favt">
				<c:forEach var="idx" begin="4" end="6">
						<div class="avtbox">
							<label for="fav${idx}">
								<img src="/cafe/img/avatar/img_avatar${idx}.png" class="w3-col avtimg">
							</label>
							<input type="radio" name="avt" id="fav${idx}" value="${idx}">
						</div>
				</c:forEach>
					</div>
				</div>
			</div>
		</form>
		<div class="w3-col w3-margin-top">
			<div class="w3-half w3-button w3-round-large w3-orange" id="rbtn">reset</div>
			<div class="w3-half w3-button w3-round-large w3-blue" id="sbtn">submit</div>
		</div>	
		
		<!-- message modal -->
		<div id="id01" class="w3-modal">
		  <div class="w3-modal-content mxw600 w3-card-4">
			    <header class="w3-container w3-teal">
			      <span class="w3-button w3-display-topright md1">&times;</span>
			      <h2>입력 오류</h2>
			    </header>
			    <div class="w3-container w3-margin">
			      <h4 class="w3-text-red w3-center w3-margin">필수 입력 사항을 확인하세요.</h4>
			    </div>
	   		</div>
		</div>
	</div>
</body>
</html>