<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="cn.cat.entity.Blog" %> 
<%@page import="cn.cat.entity.common.Page"%>
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


<div class="container-fluid"  style="height:750px;overflow: y;">
<div class="row">
 <div class="col-md-1" style="background-color: "> 
  </div>
 <!--中间栏  -->
 
 <div class="col-md-7"style="height:750px;overflow: y;">
  <label style="font-size: 16px;margin-top: 10px;">
    <span class="glyphicon glyphicon-list" style="color: gray" aria-hidden="true"></span>
    <span style=":10px; font-size: 20px">搜索结果</span>
   </label>
  
    <hr style="border: 1px solid silver">
        <!--显示内容  -->
  <%
				List<Blog> list = (List<Blog>)request.getAttribute("list");
			    int size = list == null ? 0 : list.size();
			    if(size!=0){
				for(int i = 0; i < size; i++){
					Blog blog = list.get(i);
			%>
	  
   <div id="1" class="inline">
      <a style="font-size:25px;text-decoration:none;" href="<%=request.getContextPath()%>/web_blog_detail?id=<%=blog.getId()%>"><%= blog.getTitle()%></a>
      <a style="float: right;text-decoration:none;" href="<%=request.getContextPath()%>/web_blog_detail?id=<%=blog.getId()%>" class="read_more_button">read more</a>
    </div>
    <div class="row" style="padding-top: 12px;font-size:12px;height: 160px;overflow: hidden;">
      <div class="col-lg-4 col-sm-4">
          <!-- 图片区 -->
         <div  id="2" style="text-align: center; height:400px;width: 200px;">
          <a href="" class="thumbnail" >
          <img src=" <%= request.getContextPath()%>/images<%=blog.getPic_url()%>/<%=blog.getPhotoname()%>" height="120px" width="130px"></a>
         </div>
       </div>
       <div class="col-lg-8 col-sm-8" style="font-size: 14px">
          <div id="3">
           <p><%= blog.getContent()%></p>
          </div>
        </div>
    </div>
            <div id="4" style="text-align: right">
                <label style="font-size: 12px;float: left"><%= blog.getCreate_time()%></label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                
                <label style="font-size: 12px;width: 70px;text-align: left">
                <span class="glyphicon glyphicon-eye-open" style="color: gray" aria-hidden="true"></span> 
                <a style="text-decoration:none;" href="<%=request.getContextPath()%>/web_blog_detail?id=<%=blog.getId()%>">阅读</a>(<%=blog.getClick_times() %>)</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                
                <label style="font-size: 12px;width: 70px;text-align: left">
                <span class="glyphicon glyphicon-edit" style="color: gray" aria-hidden="true"></span> 
                 <a style="text-decoration:none;" href="<%=request.getContextPath()%>/web_blog_detail?id=<%=blog.getId()%>">评论</a>(<%=blog.getComment_times() %>)</label>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                
                <label style="font-size: 12px;width: 70px;text-align: left">                
                <span class="glyphicon glyphicon-thumbs-up" style="color: gray" aria-hidden="true"></span>推荐(0)</label>
            </div>
   <hr style="border:0.5px solid silver">
   <br>
   
    <%
      }
				
			    }
	else{
		%>
		<p>暂未搜索到相关内容</p>
	<%
	}
     %>		
     
   </div>
   
    <!-- 右边栏 -->
    <div class="col-md-4"style="height:750px;overflow:y;">
    <legend style="margin-top: 15px;">站外信息</legend>
     <div class="container-fluid" style="margin-top: 10px;">
     <div class="list-group">
	 <a href="#" class="list-group-item active">
		<h4 class="list-group-item-heading">
			感谢开发过程中以下网站提供的学习资料
		</h4>
	</a>
	<a href="http://www.imooc.com/" class="list-group-item">
		<h4 class="list-group-item-heading">
			慕课网
		</h4>
		<p class="list-group-item-text">
			
		</p>
	</a>
	<a href="http://www.runoob.com/" class="list-group-item">
		<h4 class="list-group-item-heading">
		菜鸟教程
		</h4>
		<p class="list-group-item-text">
			
		</p>
	</a>
	<a href="http://www.bootcss.com/" class="list-group-item">
		<h4 class="list-group-item-heading">
		Bootstrap中文网
		</h4>
		
	</a>
	<a href="http://www.csdn.net/" class="list-group-item">
		<h4 class="list-group-item-heading">
		CSDN
		</h4>
		
	</a>
</div>
      
      
      </div>
    <div class="container-fluid">
     <h3>本站开源地址:</h3>
     <p style="font-size: 20px;"><a href="https://github.com/LornaLiang">梁娜的GitHub</a></p>
     </div>
    </div>
    
    </div><!--三栏式 -->

</div>






<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>