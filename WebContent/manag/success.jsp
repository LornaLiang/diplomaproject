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
<title>管理我的博客</title>

<style>
a{
font-size: 20px;
}
</style>
</head>
<body>
<jsp:include page="admin_common.jsp" />

<!--三栏式布局  -->
<div class="container-fluid">
 <div class="row">
 <div class="col-md-5"></div>
 
  <div class="col-md-4">
   <a href="<%=request.getContextPath()%>/blog_list">日志列表</a>
   <br><br>
   <a href="<%=request.getContextPath()%>/album_list">相册列表</a>
   <br><br>
    
  </div>
 <div class="col-md-3"></div>
 </div>
</div>

<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>