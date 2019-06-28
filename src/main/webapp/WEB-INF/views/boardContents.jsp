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
      
            <tr>
                <th>제목: </th>
                <td><input type="text"   name="title" class="form-control" value=${contents.title }/></td>
            </tr>
            <tr>
                <th>내용: </th>
                <td><textarea cols="10"   name="content" class="form-control" >${contents.content}</textarea></td>
            </tr>
            
            <td><textarea cols="20" name="comment" class="form-control"></textarea></td>
            
            
            <tr>
                <td colspan="2">
                  
                    <input type="reset" value="reset" id=reset class="pull-left"/>
                    <input type="button" value="글 목록으로... " id=list class="pull-right" />
                    <!-- <a class="btn btn-default" onclick="sendData()"> 등록 </a>
                    <a class="btn btn-default" type="reset"> reset </a>
                    <a class="btn btn-default" onclick="javascript:location.href='list.jsp'">글 목록으로...</a> -->
                </td>
            </tr>
       
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