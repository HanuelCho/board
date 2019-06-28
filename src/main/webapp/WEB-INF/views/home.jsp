<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<button id="toInput">로그인</button>
	<button id="toOutput">Output</button>
	<button id="join">회원가입</button>
	<script>
	document.getElementById("toInput").onclick = function(){
		location.href="inputForm"
	}
	document.getElementById("toOutput").onclick = function(){
		location.href="outputForm"
	}
	document.getElementById("join").onclick = function(){
		location.href="joinForm"
	}
	</script>
</body>
</html>