<%@page import="java.util.List"%>
<%@page import="cn.cat.entity.Album" %>
<%@page import="cn.cat.entity.common.Page"%>
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
<title>我的相册列表</title>

<style>

</style>
</head>
<body>
<jsp:include page="admin_common.jsp" />
<!--主体内容 -->
<div class="container-fluid row">
    <div class="container table_box col-lg-2 col-md-1"></div>
    <div class="container table_box col-lg-8 col-md-10 col-xs-12" style="padding-left: 68px">
        <!-- 管理导航栏 -->
        <ul class="nav nav-tabs" role="tablist" id="feature-tab">             <li class="active">             
            <a href="<%= request.getContextPath()%>/album_list" role="tab" >
                                  相册                           
           </a>                                       
             </li>
             <li><a href="<%= request.getContextPath()%>/blog_list"  >
                                文章</a></li>
        </ul> 
         <div class="tab-content">

      
 <!--相册列表  -->
       <div class="tab-pane active" id="">       
        <div style="padding-top: 10px">
            <a data-toggle="modal" data-target="#add-album-modal"
             class="btn btn-info btn-sm" >传照片</a>
            <table class="table table-hover" id="album-table">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>标题</th>
                    <th>图片</th>
                    <th>创建时间</th>
                    
                    <th>操作</th>
                </tr>
                </thead>               
            
             <tbody>
             
             <%
             Page<Album> pager = (Page<Album>)request.getAttribute("list");		
             if(pager !=null){
			    	List<Album> list=pager.getItems();
					int size = list == null ? 0 : list.size();	
      				for(int i = 0; i < size; i++){
					Album album = list.get(i);
			%>
				<tr>
					<td ><%=i+1 %></td>
					<td ><%= album.getTitle()%></td>
					<td >
					 <a href="">
                         <img src="<%= request.getContextPath()%>/images<%=album.getUrl()%>/<%=album.getPhotoname()%>" height="30px" style="height: 30px">
                     </a>
					</td>
					<td><%= album.getCreate_time()%></td>
					
					<td>
					 
                        <a href="<%=request.getContextPath()%>/manag/album_detail?id=<%= album.getId()%>">修改</a>
                        <a href="javascript: doDelete(<%= album.getId()%>)">删除</a>
                   
					
					</td>
					
				</tr>
			<% 
				}
			}
			%>
            <tfooter>
			<tr>
				<td colspan="6">共 <%=pager.getTotalElements()%>条, 共<%= pager.getTotalPages()%>页,
					当前是第<%= pager.getNumber() %>页&nbsp;&nbsp;&nbsp; <%
					    out.println("<a href='" + request.getContextPath() + "/album_list?page=1'>首页</a>&nbsp;");
						if(pager.getNumber() == 1){
							out.println("<a href='javascript:;'>上一页</a>&nbsp;");
						}else{
							out.println("<a href='" + request.getContextPath() + "/album_list?page=" + (pager.getNumber() - 1) + "'>上一页</a>&nbsp;");
						}
					
						if(pager.getNumber() == pager.getTotalPages()){
							out.println("<a href='javascript:;'>下一页</a>&nbsp;");
						}else{
							out.println("<a href='" + request.getContextPath() + "/album_list?page=" + (pager.getNumber() + 1) + "'>下一页</a>&nbsp;");
						}
						out.println("<a href='" + request.getContextPath() + "/album_list?page=" + pager.getTotalPages() + "'>末页</a>&nbsp;");
					%>
				</td>
			</tr>
			</tfooter>		 
             
             </tbody>
            </table>     
        </div><!--相册列表  -->
    </div>
  </div><!-- 标签页内容 -->
    </div>
    <div class="container col-lg-2 col-md-1"></div>
  
</div><!--fluid  -->
   
<!--上传图片的对话框  -->
<div class="modal fade" id="add-album-modal" tabindex="-1" role="dialog" aria-labelledby="modal-label" aria-hidden="true">
 <div class="modal-dialog">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal">
        <span aria-hidden="true">&times;</span>
        <span class="sr-only">关闭</span>
      </button>
      <h4 class="modal-title">添加</h4>
    </div>
    <form action="<%= request.getContextPath()%>/manag/album_add" method="post" enctype="multipart/form-data">
      <div class="modal-body">
        <div>
         <label style="font-size: 15px">标题:</label>
         <input style="display: inline;font-size:15px;width:250px;" name="title" type="text" class="form-control"/>
        </div>
        <div id="pic_div" style="padding-top: 5px;" >
         <label style="font-size: 15px">图片: </label>
         <div id="show"></div>
         <!-- 存储图片地址，并显示图片 -->
         
        </div>
        <div style="padding-top: 5px">
         <input type="file" name="url" id="">
        </div>
        <div style="padding-top: 10px">
        <button>时间</button>
        <input name="create_time" type="datetime" id="getTime">
                
        </div>
    </div>
     
     <div class="modal-footer">
       <button type="submit" class="btn btn-success">添加</button>
       <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
      </div>
   </form>
  </div>
 </div>
</div>



<div class="container col-lg-2 col-md-1"></div>

<script type="text/javascript">
function doDelete(id){
	var flag = window.confirm("确定删除吗？");
	if(flag){
		window.location.href = "<%= request.getContextPath()%>/manag/album_delete?id=" + id;
	}
}

//function click(){
//	alert("q");
//	var y=document.getElementsByName("url").value;
	//alert(y);
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