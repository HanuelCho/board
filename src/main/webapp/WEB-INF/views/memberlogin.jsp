<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>멤버입니다</h2>
<%-- 	<img src="/resources/"+"${arr }"> --%>
	
	<form action="upload.do" method="post" enctype="multipart/form-data">
		
		<input type="file" name="image">
		<input type="text" name="text">
		<input type="submit" value="send">
	</form>
	<div>${arr.id } ${arr.name }</div>
	<button type=button id=logout>logout</button>
	<button type=button id=board>게시판 가기</button>
	
<%-- 	<c:forEach var="i" items="${arr}"> --%>
<%-- 		<div>${i.name} ${i.id} </div> --%>
<%-- 	</c:forEach> --%>

	<script>
		$("#logout").on("click",function(){
			location.href="logoutForm"
		})
		
		$("#board").on("click",function(){
			location.href="boardForm"
		})
	</script>


</body>
</html>