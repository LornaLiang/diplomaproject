<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="cn.cat.entity.Blog" %>
<%@page import="cn.cat.entity.Comment" %>
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
fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver}
legend{width:auto;font-size: 19px;font-style: oblique;color: black}
.a{
font-size: 20px;

}
</style>
</head>
<body>

<!--顶部导航条-->
<div class="nav a">
<div class="navbar navbar-default" role="navigation">
  
  <div class="navbar-header">
 
     　<!-- .navbar-toggle样式用于toggle收缩的内容，即nav-collapse collapse样式所在元素 -->
       <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-responsive-collapse">
         <span class="sr-only">Toggle Navigation</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
       </button>
       <!-- 确保无论是宽屏还是窄屏，navbar-brand都显示 -->
       &nbsp;
       <a href="##" class="navbar-brand">梁娜的博客</a>
  </div>
  <!-- 屏幕宽度小于768px时，div.navbar-responsive-collapse容器里的内容都会隐藏，显示icon-bar图标，当点击icon-bar图标时，再展开。屏幕大于768px时，默认显示。 -->
  <div class="collapse navbar-collapse navbar-responsive-collapse">
    	<ul class="nav navbar-nav">
    	    <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
      		<li class="active"><a href="<%= request.getContextPath()%>/web_blog_list" >
      		<span class="glyphicon glyphicon-home" ></span>首页</a></li>
      		<li>&nbsp;&nbsp;</li>
      		<li class="dropdown-toggle">
      		<a href="##" data-toggle="dropdown" class="dropdown-toggle">
      		<span class="glyphicon glyphicon-th"  ></span>
      		分类<span class="caret"></span>
      		</a>
      	      <ul class="dropdown-menu">
        	    <li><a href="<%=request.getContextPath()%>/web_class_search?type=0">学习</a></li>
        	    <li><a></a></li>
        	    <li><a href="<%=request.getContextPath()%>/web_class_search?type=1">生活</a></li>
             </ul>
        	</li>
        	<li>&nbsp;&nbsp;</li>
      		<li><a href="<%=request.getContextPath()%>/web_album_list"><span class="glyphicon glyphicon-picture" ></span>相册</a></li>
      		<li>&nbsp;&nbsp;</li>
      		<li><a href="##"data-toggle="modal" data-target="#about-modal"><span class="glyphicon glyphicon-heart" ></span>关于</a></li>
      		<li>&nbsp;&nbsp;</li>
      		<li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span>管理</a></li>
          	<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
          	<li><!-- 搜索框 -->
      		<form action="<%=request.getContextPath() %>/web_input_search" class="navbar-form navbar-left" role="search">
   	         <div class="form-group">
   		      <input type="text" class="form-control" placeholder="搜索你感兴趣的内容" />
             </div>
               <button type="submit" class="btn btn-default">搜索</button>
            </form>
      		
      		</li>
	 	</ul>
	 	
  </div> 
</div>
</div><!-- 导航条结束 -->

<!--关于  -->
<div class="modal fade" id="about-modal" tabindex="-1" role="dialog" aria-labelledby="modal-label"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                    <h4 class="modal-title" id="modal-label">关于</h4>
                </div>
                <div class="modal-body">
                    <div style="text-align: center;padding-top:30px;padding-bottom: 10px">
                        <p>这是一个分享技术与生活的博客</p>
                        <img src="images/head.jpg" width="100px" height="100px" class="img-circle">
                        <div style="padding-top: 20px">
                            <p>
                                个人微信 ：lornaliang
                            </p>
                            <p>
                                个人QQ ：1178820231
                            </p>
                            <p>
                                邮箱 ：lornaliang123@163.com
                            </p>
                            <p>
                                github ：https://github.com/LornaLiang
                            </p>
                            <p>
                                互相学习，共同进步.
                            </p>
                        </div>
                    </div>
                    <p style="text-align: right">By LornaLiang</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">了解</button>
                </div>
            </div>
        </div>
    </div>

<!-- 详情 -->	
<div class="container table_box">
    <!-- <h2 >85</h2> -->
    <h2 style="text-align:left;"><b>${blog.title}</b></h2>
       <div style="text-align: right;font-size: 16px;padding-top: 10px">
        <div style="float: left">
                      标签：                                     
        <a href="#" class="label label-info" style="font-size: 16px">${blog.type}</a>
        </div>
        <label style="font-size: 15px;text-align: left"><span class="glyphicon glyphicon-eye-open" style="color: gray" aria-hidden="true"></span> <a style="text-decoration:none;" href="">阅读</a>(${blog.click_times})</label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="font-size: 15px;text-align: left"><span class="glyphicon glyphicon-edit" style="color: gray" aria-hidden="true"></span>  <a style="text-decoration:none;" href="">评论</a>(${blog.comment_times})</label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="font-size: 15px;text-align: left"><span class="glyphicon glyphicon-thumbs-up" style="color: gray" aria-hidden="true"></span>  推荐(0)</label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <label style="font-size: 15px">${blog.create_time}</label>
    </div>
    <hr>
    <div style="padding-top: 4px;padding-left: 10px;padding-right: 10px;">
       <p> ${blog.content}</p>
    </div>
</div>

 <!--评论列表  -->
<div id="comment" class="container table_box"> 
     <hr style="border: 1px solid silver;">
        <h3 style="padding-top: 10px;padding-bottom: 10px;">
        <a href="<%=request.getContextPath()%>/web/list_comment?blog_id=${blog.id}">评论列表</a>&nbsp;&nbsp;&nbsp;&nbsp;</h3>
    <c:forEach items="${list}" var="comment">
    <div>
            <div style="padding-top: 10px;padding-left: 10px;padding-right: 10px">
        <span style="color:black;width: 40px"></span>
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



<!-- 添加评论 -->
<div class="container table_box">

    <form id="comment_id" action="<%= request.getContextPath()%>/web/add_comment" method="post">
        <fieldset >
            <legend>不说点什么吗？</legend>
            <input value="${blog.id}" type="hidden" name="blog_id">
            <div class="form-inline">
                <div class="form-group col-lg-offset-1">
                    <label style="font-size: 15px;width: 60px;">* 姓  名：</label>
                    <input style="width:200px;font-size: 15px" type="text" minlength="4" maxlength="10" class="form-control" name="username" required>
                </div>
            </div>
            <div class="form-inline">
                <div class="form-group  col-lg-offset-1" >
                    <label style="font-size: 15px;width: 60px;padding-top: 20px" >* 邮  箱：</label>
                    <input style="width:200px;font-size: 15px" type="email" class="form-control" name="email" required>
                </div>
            </div>
            <div class="form-inline" style="padding-top: 20px">
                <div class="form-group  col-lg-offset-1" >
                    <label style="font-size: 15px;width: 60px" >* 内  容：</label>
                    <textarea name="content" style="width: 500px" class="form-control" rows="4"></textarea>
                </div>
            </div>
	            <div class="col-lg-offset-1" style="padding-top: 20px;padding-left: 60px;padding-bottom: 15px">
                <button type="submit"  style="width: 200px;text-align: center" class="btn btn-info">评论</button>
            </div>
        </fieldset>
        <input type="hidden" id="blog_id" value="${comment.blog_id}" >
    </form>
</div>



<script type="text/javascript">
</script>


<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>