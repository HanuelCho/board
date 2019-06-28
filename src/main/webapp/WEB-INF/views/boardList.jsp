<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 width="600px">
		<tr>
			<th>제목</th>
			<th>내용</th>
		</tr>

		<c:forEach var="i" items="${list }">
			<tr>
				<td><a href="boardContents?seq=${i.board_seq }">${i.title }</a></td>
				
				<td>${i.content }</td>
				<%-- 		${i.filename } --%>

			</tr>
		</c:forEach>
	</table>
</body>
</html>