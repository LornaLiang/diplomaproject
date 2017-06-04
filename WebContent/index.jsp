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
<title></title>

<style>
.a{
font-size: 20px;

}
.carousel{
max-height: 700px;
max-width: 1200px;
margin-left: 60px;
}
.carousel img{
width: 100%
}
.row{
height:700px;
}
body{
height:730px;
width:1366px;
background-image: url("images/home.jpg");
background-repeat: no-repeat;
}
.a{
width:455px;
height:200px;
margin-top:200px;
background-color: #DDD7DB;
position:fixed;

filter:alpha(Opacity=60);-moz-opacity:0.6;opacity: 0.6
}
</style>
</head>
<body>
<!-- 三栏式响应布局 -->
<div class="container-fluid">
<div class="row">
<div class="col-md-4" style="background-color: "> 
  </div>
  <div class="col-md-4" style="background-color: ">
  <div class="a">
  <p><span class="glyphicon glyphicon-heart"></span>一个分享技术与生活的个人博客</p>
  <p><span class="glyphicon glyphicon-heart"></span>期待您的建议</p>
  <h2><a href="<%= request.getContextPath()%>/web_blog_list">欢迎进入主页</a></h2> 
  </div>
  </div>
  <div class="col-md-4" style="background-color: "> 
  </div>
</div>
</div>
<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>