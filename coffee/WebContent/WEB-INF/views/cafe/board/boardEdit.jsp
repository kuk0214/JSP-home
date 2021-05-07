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
<%--
	서버에게 페이지를 요청하는 방식 ]
		1. GET 방식
			요청 방법 ]
				1) a 태그로 요청하는 방법
				==> href 소것ㅇ에 요청할 페이지를 기술하면 된다.
					예 ]
						<a herf="/cafe/main.cafe?id=euns">홈</a>
						
				2) 자바 스크립트에서 요청하는 방법
					예 ]
						location.href = '/cafe/main.cafe';
				
				3) form 태그를 이용해서 요청하는 방법
				==> form 태그의 method 속성에 get이라고 기술하고
					action 속성에 속성값을 요청할 문서를 기술한다.
					
					예 ]
						<form method="GET" action="/cafe/main.cafe" name="frm" id="frm">
							<input type="hidden" name="id" id="id">
						</form>
						
						자바 스크립트에서 만들어진 폼태그를 제출(서브밋) 한다.
						
						document.frm.submit();
						
						jQuery에서 제출하는 방법
							$('#frm').submit();
				
				4) 태그 라이브러리로 처리하는 방법
						<c:redirect url="/cafe/main.cafe">
							<c:param name="id" value=euns" />
						</c:redirect>
				
				5) 주소표시줄에 직접 입력하는 방법
					http://localhost/cafe/main.cafe?id=euns
		2. POST 방식
		==> 같이 전송되는 데이터(파라미터)가 주소표시줄에 노출되지 않는 방식이다.
			http 통신의 headers에 포함되어 전송된다.
			
			방법 ]
				<form method="POST" action="/cafe/main.cafe" name="frm" id="frm">
					<input type="hidden" name="id" id="id" value="euns">
				</form>
	
	우리가 페이지를 전환 또는 처리요청을 한다는 것은
	서버에게 원하는 페이지를 달라고 요청하거나 또는
	서버에게 전송하는 데이터를 처리해 달라고 요청하는 것이다.
	
	이때 데이터가 같이 전송이 될 경우
	위의 두가지 방식으로 데이터를 전송을 할 수 있는데
	큰 데이터의 경우는 GET 방식의 경우는 256 바이트 이상의 크기는 전송 될 수 없다. 
	이런 사이즈의 제한 없이 사용할 수 있는 방법은 POST 방식이다.
 --%>
<script type="text/javascript">
	var cnt = 1;
	function getCnt() {
		return cnt;
	}
	function setCnt() {
		cnt += 1;
	}
	$(document).ready(function() {
		$('#hbtn').click(function() {
			location.href = '/cafe/main.cafe';	
		});
		
		$('#bbtn').click(function() {
			$('#lfrm').submit();
		});
		
		$('#rbtn').click(function() {
			document.efrm.reset();
		});
		
		$('#sbtn').click(function() {
			$('#efrm').submit();
		});
		
		function addTag(e, el) {
			var tmp = $(el).val();
			var taglist = $('.file');
			var len = taglist.legth;
			var tid = $(el).attr('id');
			
			if(!tmp && len != 1) {
				$(el).remove();
				$('#img_' + tid).remove();
			}
			
			if(tmp) {
				setCnt();
				var idCnt = getCnt();
				$('#filefr').append('<input type="file" name="file' + idCnt + '" id="file' + idCnt + '" class="w3-col w3-input w3-round w3-border mgb10 file">');
				
				// 파일 꺼내오고...
				var img = URL.createObjectURL(e.target.files[0]);
				
				$('#fileImg').append('<div class="inblock box120 pdAll10 mgl10 w3-border w3-border-grey w3-card" id="img_' + tid + '">' +
											'<div class="w3-col imgBox100">' + 
												'<img class="w3-col img100" src="' + img + '">' +
											'</div>' +
									  '</div>');
				
				// 반드시 추가된 태그에만 이벤트를 등록한다. 
				var tmp = $('#file' + idCnt);
				$(tmp).change(function(event) {
					addTag(event, $(tmp));
				});
				
				
			}
			
			taglist = $('.file');
			var len = taglist.length;
			
			if(len== 1) {
				$('#fileImg').css('display', 'none');					
			} else {
				$('#fileImg').css('display', 'block');										
			}
		}
		
		$('.file').change(function(e) {
			addTag(e, this);
		});
	});
</script>
</head>
<body>
	<form method="POST" action="/cafe/board/board.cafe" id="lfrm" name="lfrm">
		<input type="hidden" name="nowPage" id="nowPage" value="${param.nowPage}">
	</form>
	<div class="w3-content mxw700 w3-margin-top w3-padding">
		<h1 class="w3-purple w3-padding w3-center w3-card-4 w3-margin-top w3-margin-bottom">${DATA.id} 님 글 수정하기</h1>
		<!-- form 태그 -->
		<form method="POST" action="/cafe/board/boardEditProc.cafe" id="efrm" name="efrm" 
				class="w3-col w3-padding w3-margin-bottom w3-card-4 ">
			<div class="w3-col w3-margin-top pdb10 w3-border-bottom w3-border-light-grey">
				<label for="title" class="w3-col w150 w3-center w3-text-grey pdt5 ft14">글제목</label>
				<div class="w3-rest pdr30">
					<input class="w3-rest w3-input w3-round w3-border" id="title" name="title" value="${DATA.title}">
				</div>
			</div>
			<div class="w3-col w3-margin-top pdb10 w3-border-bottom w3-border-light-grey">
				<label class="w3-col w150 w3-center w3-text-grey pdt5 ft14">첨부파일</label>
				<div class="w3-rest pdr30">
					<div class="w3-col w3-margin-top w3-center pdAll10" id="addImg">
			<c:forEach var="data" items="${LIST}">
						<div class="inblock box120 pdAll10 mgl10 w3-border w3-border-grey w3-card">
							<div class="w3-col imgBox100"> 
								<img class="w3-col img100" src="/cafe/img/upload/${data.savename}" id="img_${data.fno}">
							</div>
						</div>
			</c:forEach>						
					</div>
				</div>
			</div>
			
			<div class="w3-col w3-margin-top pdb10 w3-border-bottom w3-border-light-grey">
				<label class="w3-col w150 w3-center w3-text-grey pdt5 ft14">파일추가</label>
				<div class="w3-rest pdr30">
					<div class="w3-col w3-margin-top w3-center pdAll10" id="fileImg">
			<c:forEach var="data" items="${LIST}">
						<div class="inblock box120 pdAll10 mgl10 w3-border w3-border-grey w3-card">
							<div class="w3-col imgBox100"> 
								<img class="w3-col img100" src="/cafe/img/upload/${data.savename}" id="img_file1">
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
			<div class="w3-quater w3-green w3-hover-lime w3-button" id="hbtn">home</div>
			<div class="w3-quater w3-green w3-hover-lime w3-button" id="bbtn">board</div>
			<div class="w3-quater w3-blue w3-hover-pink w3-button" id="rbtn">reset</div>
			<div class="w3-quater w3-orange w3-hover-red w3-button" id="sbtn">submit</div>
		</div>
	</div>
</body>
</html>