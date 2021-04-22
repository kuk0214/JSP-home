<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/cafe/css/w3.css">
<link rel="stylesheet" type="text/css" href="/cafe/css/user.css">
<script type="text/javascript" src="/cafe/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/cafe/js/w3color.js"></script>
</head>
<body>
<%!
	//여기에 만들어지는 변수는 
	// 클래스 블럭 바로 아래에서 만들어지는 변수 즉 전역변수(멤버변수)가된다.
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> name = new ArrayList<String>();

	public void setList() {
		list.add("w3-red");
		list.add("w3-pink");
		list.add("w3-purple");
		list.add("w3-deep-purple");
		list.add("w3-blue");
		list.add("w3-cyan");
		list.add("w3-aqua");
		list.add("w3-green");
		list.add("w3-light-green");
		list.add("w3-lime");
		list.add("w3-yellow");
		list.add("w3-amber");
		list.add("w3-orange");
		list.add("w3-deep-orange");
		list.add("w3-black");
		list.add("w3-dark-grey");
		list.add("w3-grey");
		list.add("w3-light-grey");
		list.add("w3-blue-grey");
		list.add("w3-brown");
		list.add("w3-pale-red");
		list.add("w3-sand");
		list.add("w3-pale-yellow");
		list.add("w3-khaki");
		list.add("w3-pale-blue");
		list.add("w3-light-blue");
		
		name.add("김기은");
		name.add("곽채원");
		name.add("김유진");
		name.add("박용수");
		name.add("박현규");
		name.add("신현식");
	}
	// 여기까지는 모두 변수를 준비하고 함수를 만들어두기만 한 것이다.
	// 따라서 아직 list에 데이터가 채워져 있지는 않다.
%>

<%
	String sColor = "w3-lime";
	String first = "은석";
	String last = "전"
;	// 함수를 호출해서 변수에 데이터를 채워주자.
	setList();
%>
	<div class="w3-content mxw600 w3-center w3-margin-top">
		<h1 class="w3-margin-top w3-margin-bottom w3-deep-orange w3-padding w3-card-4">우 리 반</h1>
			<div class="w3-button <%= sColor %>"><%= (last + first) %></div>
	<% 
		for(int i = 1 ; i < name.size() ; i++ ) {		
	%>
			<div class="w3-button <%= list.get(i) %>"><%= name.get(i) %></div>
	<%
		}
	%>
	</div>
</body>
</html>