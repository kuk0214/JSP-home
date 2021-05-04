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
	#fileImg {
		display: none;
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
					alert('# 제목&내용을 확인하세요!');
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
<%--
	이 뷰는 글쓰기 폼을 보여주면 된다.
	POST 방식은 내부적으로 2가지 방식으로 나뉘어서 서버에 데이터가 전송이 된다.
		
		1. parameter 방식
			==> value 속성 값만 서버에 "키값=데이터" 의 형태로 전달하는 방식
			
			사용하는 방법 ]
				req.getParameter("키값");
			의 방법으로 데이터를 꺼내서 사용하면 된다.
			
		2. stream 방식
			==> 폼안에 있는 내용을 스트림으로 처리해서 byte[] 로 만들어서 서버에 전달하는 방식
			
				따라서
					서버에서는 스트림으로 만들어서 받아야 한다.
			
			파일 첨부가 있을 때 parameter 방식으로 보내면
			파일의 이름만 서버에 전송된다.
			( ==> 파일의 내용은 전송이 되지 않는다.)
			파일의 내용까지 서버에 전달하기 위해서는 
			파일을 스트림으로 바꿔서 전달해야 한다.
			
				encType="multipart/form-data"
			라는 속성이 스트림 방식으로 처리하라는 의미를 가진 속성이다.
			
			다행스럽게도 요근래 스트림 제어를 위한 라이브러리가 많이 제공되고 있다.
				1. cos.jar
				2. commons-fileupload.jar
			이 대표적이다.
			
			결론적으로
				파일 첨부는 파일의 내용을 서버에 전달해서
				서버가 그 파일을 원하는 위치에 저장하도록 하는 것이다.
				따라서 반드시 스트림 방식으로 전달해야 하고
				결론적으로 폼을 만들때
					encType="multipart/form-data"
				를 해당 폼태그의 속성을 지정해야 한다.
	참고 ]
		위에서 언급한 것처럼 파일 업로드에 필요한 대표적인 라이브러리는 두가지가 있는데
		이 중 cos.jar를 이용해서 파일을 업로드하는 경우는
			name 속성값이 하나에 하나씩 밖에 업로드 되지 않는다.
		따라서 한 name에 하나씩만 전달되도록 해야 한다.
		
	참고 ]
		<a href="">은 하이퍼링크 기능을 가진 태그이다.
		문제는 href=""로 하면 페이지 자기자신을 다시 요청하는 링크가 된다.
		
		만약 <a>태그의 하이퍼 링크 기능을 제거하고
		자바 스크립트나 jquery를 이용하고자 하면 하이퍼 링크 기능 자체를 제거해 주어야 한다.
			방법 ]
				href="#"
		로 처리하면 링크 기능을 제거해 준다. 
 --%>	
		<!-- form 태그 -->
		<form method="POST" action="/cafe/board/boardWriteProc.cafe" name="frm" id="frm" encType="multipart/form-data"
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
					<input type="file" name="file1" id="file1" class="w3-col w3-input w3-round w3-border file">
					<div class="w3-col w3-margin-top" id="fileImg"></div>
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