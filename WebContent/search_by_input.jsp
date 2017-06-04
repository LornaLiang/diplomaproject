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

</style>
</head>
<body>
<jsp:include page="navcommon.jsp" />
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
          <img src="" height="120px" width="130px"></a>
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