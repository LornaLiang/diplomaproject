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