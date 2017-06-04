<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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

</style>
</head>
<body>
<!--评论列表  -->
   
  <div id="comment" class="container table_box"> 
     <hr style="border: 1px solid silver;">
        <h3 style="padding-top: 10px">
        <a href="<%=request.getContextPath()%>/web/list_comment?blog_id=${blog.id}">评论列表</a>&nbsp;&nbsp;&nbsp;&nbsp;条</h3>
    <c:forEach items="${list}" var="comment">
    <div>
            <div style="padding-top: 10px;padding-left: 10px;padding-right: 10px">
        <span style="color:black;width: 40px">楼</span>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <span class="glyphicon glyphicon-user" style="color: gray ;width:150px" aria-hidden="true">&nbsp;${comment.username}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span class="glyphicon glyphicon-envelope" style="color: gray;width:300px" aria-hidden="true">&nbsp;${comment.email}</span>
        <div style="font-size:16px;padding: 20px 50px 10px 45px;">
        <p>${comment.content}</p>
        </div>
    </div>
        <div style="color:gray;float: right">
            <i>评论于${comment.create_time}</i>
        </div>
        <hr>
         
    </div>
    </c:forEach>
</div>

<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>