<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--引入Bootstrap文件  -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>登录我的博客</title>

<style>
body{
height:700px;
width: 1366px;
background-image: url("images/log.jpg");
background-repeat: no-repeat;
}
.a{
height: 300px;
width: 300px;
margin-left:200px ;
margin-top:200px ;
background-color: ;
}
.b{
font-size: 20px;
}
</style>
</head>
<body>
<div class="a" >
 
 <form class="form-horizontal" action="adm_login">
  <div class="control-group" >
    <label class="control-label b" for="inputEmail">用户名</label>
    <div class="controls" >
      <input type="text" id="inputEmail" name="name" placeholder="请输入用户名">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label b" for="inputPassword">密码</label>
    <br>
    <div class="controls">
      <input type="password" name="password" id="inputPassword" placeholder="请输入密码">
    </div>
  </div>
  <div class="control-group">
    <div class="controls">
      <label class="checkbox b" >
        <input type="checkbox"> 记住我
      </label>
      <button type="submit" class="btn b">登录</button>
      <button type="reset" class="btn b">重置</button>
    </div>
    
  </div>
   
</form>

</div>
<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>