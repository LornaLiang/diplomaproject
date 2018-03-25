<%@page import="cn.cat.entity.Album" %>
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
<title>修改图片</title>

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
  <%Album album=(Album)request.getAttribute("album");   %>
    <a href="<%=request.getContextPath()%>/manag/album_detail?id=<%=album.getId() %>">修改</a>
  </li>
  <li><a href="<%=request.getContextPath()%>/album_list"><h4>返回列表</h4></a></li>
 </ul>
   </div>
   <div>
  <form action="<%= request.getContextPath()%>/manag/album_edit" method="post" enctype="multipart/form-data">
      <div class="modal-body">
        <div>
         <label style="font-size: 15px">标题:</label>
         <input style="display: inline;font-size:15px;width:250px;" 
         name="title" type="text" 
         class="form-control" value="<%=album.getTitle()%>"/>
         <input type="hidden" value="<%=album.getId() %>" name="id">
        </div>
        <div id="pic_div" style="padding-top: 5px;" >
         <label style="font-size: 15px">图片: </label>
         <div id="show"></div>
         <!-- 存储图片地址，并显示图片 -->
          <input type="hidden" name="url" id="pictureSrc">
        </div>
        <div style="padding-top: 5px">
         <input type="file" name="image" id="imageFile">
        </div>
        <div style="padding-top: 5px">
         <button id="upload" onclick="return false;">上传</button>
        </div>
        <div style="padding-top: 10px">
        <button>时间</button>
        <input name="create_time" type="datetime" id="getTime">
                
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
<script type="text/javascript">

//获取时间
window.onload = function(){
	function getDate(){
	debugger;
 var today = new Date(); 
 var date; 
 date = (today.getFullYear()) +"-" + (today.getMonth() + 1 ) + "-" + today.getDate() + "-" + today.toLocaleTimeString(); 
 return date;
 }
 window.setInterval(function(){
 document.getElementById("getTime").value=getDate();
 }, 1000);
}


</script>


   




<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>