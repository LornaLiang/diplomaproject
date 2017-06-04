<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="cn.cat.entity.Blog" %>
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
<title>${blog.type}</title>

<style>

</style>
</head>
<body>
<jsp:include page="navcommon.jsp" />

<!-- 三栏式流式布局 -->
<div class="container-fluid"><!--自适应流式  -->
<div class="row">
<div class="col-md-2"></div>

<div class="clo-md-8"><!--中间栏显示内容，其他两栏留间距  -->
<c:forEach items="${list}" var="blog">
    <div class="container table_box">
  <hr style="border: 1px solid silver">
            <div class="inline">
                <a style="font-size:30px;text-decoration:none;" href="<%=request.getContextPath() %>/web_blog_detail?id=${blog.id}">${blog.title}</a>
            </div>
                <div class="row" style="padding-top: 14px;font-size:12px;height: 200px;overflow: hidden;">
                    <div class="col-lg-3 col-sm-3">
                        <div style="text-align: center; " ><a href=""  class="thumbnail" >
                        <img src="${pageContext.request.contextPath}/images${blog.pic_url}/${blog.photoname}" height="140px"></a>
                        </div>
                    </div>
                    <div class="col-lg-9 col-sm-9" style="font-size: 14px;">
                        <div>
                        <p>${blog.content}</p>
                        </div>
                    </div>
                </div>
            <div style="text-align: right;padding-top: 20px" >
                <label style="font-size: 13px">${blog.create_time}</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label style="font-size: 15px"><span class="glyphicon glyphicon-eye-open" style="color: gray" aria-hidden="true"></span> <a style="text-decoration:none;" href="<%=request.getContextPath() %>/web_blog_detail?id=${blog.id}">阅读</a>(${blog.click_times})</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label style="font-size: 15px"><span class="glyphicon glyphicon-edit" style="color: gray" aria-hidden="true"></span>  <a style="text-decoration:none;" href="<%=request.getContextPath() %>/web_blog_detail?id=${blog.id}#comment_id">评论</a>(${blog.comment_times })</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label style="font-size: 15px"><span class="glyphicon glyphicon-thumbs-up" style="color: gray" aria-hidden="true"></span> 推荐(0)</label>
            
            <hr/>
       </div>
</div>
</c:forEach>
</div>

<div class="col-md-2"></div>
</div>
</div>







<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>