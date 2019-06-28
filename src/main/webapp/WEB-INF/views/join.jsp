<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body">
            <h5 class="card-title text-center">Register</h5>
            <form class="form-signin" action="joinProc">
              <div class="form-label-group">
                <input type="text" id="inputUserame" name=name class="form-control" placeholder="Username" required autofocus>
                <label for="inputUserame">Username</label>
              </div>

              <div class="form-label-group">
                <input type="email" id="inputEmail" name=id class="form-control" placeholder="Email address" required>
                <label for="inputEmail">Email address</label><span id="span"></span>
              </div>
              
              <hr>

              <div class="form-label-group">
                <input type="password" id="inputPassword" name=pw  class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>
              
              <div class="form-label-group">
               
              </div>

              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
              <a class="d-block text-center mt-2 small" href="#">Sign In</a>
              <hr class="my-4">
              <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign up with Google</button>
              <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign up with Facebook</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script>
  	$("#inputEmail").on("input",function(){
  		$.ajax({
  			url:"ajax.do",
  			data:{
  				id:$("#inputEmail").val()
  			}
  		}).done(function(resp){
  			var result= resp;
  			if(result==1){
  				$("#span").text("사용할수 없는 아이디입니다");
  			}else{
  				$("#span").text("사용가능한 아이디 입니다.");
  			}
  		})
  	})
  
  </script>
  
  
</body>
</html>