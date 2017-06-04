<%@page import="cn.cat.entity.Blog" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--引入Bootstrap文件  -->
<script src="//cdn.ckeditor.com/4.5.10/standard/ckeditor.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>修改日志</title>

<style>
</style>
</head>
<body>
<jsp:include page="admin_common.jsp" />
<!--响应式三栏布局  -->
<div class="container-fluid">
<div class="row">
<!--左边  -->
<div class="col-md-2" style="background-color: "> </div>
<!-- 中间 -->
<div class="col-md-8" style="background-color: "> 
  <!--编辑的对话框  -->
   <div >
  <ul class="nav nav-tabs">
  <li class="active">
  <%Blog blog=(Blog)request.getAttribute("blog");   %>
    <a href="<%=request.getContextPath()%>/manag/blog_detail?id=<%=blog.getId() %>">修改</a>
  </li>
  <li><a href="<%=request.getContextPath()%>/blog_list"><h4>返回列表</h4></a></li>
 </ul>
   </div>
   <div>
   <form action="<%=request.getContextPath()%>/manag/blog_edit?id=<%=blog.getId() %>" method="post">
    <div >
     <div>
       <label style="font-size: 15px">标题:</label>
       <input style="display: inline;font-size:15px;
       width:250px;" name="title" type="text" 
        value="<%=blog.getTitle() %>"/>
     </div>
     <div style="padding-top: 5px">
      <label style="font-size: 15px">分类:</label>
      <select name="type" class="form-control" style="font-size:15px;width:250px;display: inline">
       <option>学习</option>
       <option>生活</option>
       
      </select>
     </div>
     <div id="pic_div" style="padding-top: 5px;" >
       <label style="font-size: 15px">图片: </label>
       <div id="show"></div>
       <!-- 存储图片地址，并显示图片 -->
       <input type="hidden" name="pic_url" id="pictureSrc" value="">
     </div>
     <div style="padding-top: 5px">
      <input type="file" name="image" id="imageFile">
     </div>
     <div style="padding-top: 5px">
       <button id="upload" onclick="return false;">上传</button>
     </div>
     <div style="padding-top: 8px">
         <textarea name="content" class="ckeditor" >
         <%=blog.getContent() %>
         </textarea>
     </div>
   </div>
    <input type="hidden" name="userType" value="1">
    <div class="modal-footer">
      <button type="submit" class="btn btn-success">修改</button>
      <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
    </div>
   </form>
</div>


  
  
  
  
  </div>
<!-- 右边 -->
<div class="col-md-2" style="background-color: "> 
  </div>
</div>



</div>





<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>