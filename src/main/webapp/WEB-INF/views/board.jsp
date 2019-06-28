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
	<h4>게시판</h4>
	<div class="container">
<table class="table table-bordered">
    <thead>
        <caption> 글쓰기 </caption>
    </thead>
    <tbody>
        <form id=submitForm action="sendProc" method="post">
            <tr>
                <th>제목: </th>
                <td><input type="text" placeholder="제목을 입력하세요. "  name="title" class="form-control"/></td>
            </tr>
            <tr>
                <th>내용: </th>
                <td><textarea cols="10" placeholder="내용을 입력하세요. "  name="content" class="form-control"></textarea></td>
            </tr>
            <tr>
                <th>첨부파일: </th>
                <td><input type="file" placeholder="파일을 선택하세요. "  name="filename" class="form-control"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" value="등록"  id=send class="pull-right"/>
                    <input type="reset" value="reset" id=reset class="pull-left"/>
                    <input type="button" value="글 목록으로... " id=list class="pull-right" />
                    <!-- <a class="btn btn-default" onclick="sendData()"> 등록 </a>
                    <a class="btn btn-default" type="reset"> reset </a>
                    <a class="btn btn-default" onclick="javascript:location.href='list.jsp'">글 목록으로...</a> -->
                </td>
            </tr>
        </form>
    </tbody>
    
    <script>
    	$("#send").on("click",function(){
    		$("#submitForm").submit()
    	})
    	$("#list").on("click",function(){
    		location.href="listForm";
    	})
    </script>
</table>
</div>

</body>
</html>