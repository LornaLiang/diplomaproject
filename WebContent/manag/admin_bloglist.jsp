<%@page import="java.util.List"%>
<%@page import="cn.cat.entity.Blog" %>
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
<script src="//cdn.ckeditor.com/4.5.10/standard/ckeditor.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>我的日志列表</title>
<!-- 样式表（响应式） -->
<style>
.a{
text-align: center;
}
</style>
</head>
<body>
<jsp:include page="admin_common.jsp" />
<!--主体内容 -->
<div class="container-fluid row">
    <div class="container table_box col-lg-2 col-md-1"></div>
    <div class="container table_box col-lg-8 col-md-10 col-xs-12" style="padding-left: 68px">
        <!-- 管理导航栏 -->
        <ul class="nav nav-tabs" role="tablist" id="feature-tab">
            <li class="active"><a href="<%= request.getContextPath()%>/blog_list"  >
                                文章</a></li>
             <li>             
            <a href="<%= request.getContextPath()%>/album_list">
                                  相册                           
           </a>                                       
             </li>
        </ul> 
         <div class="tab-content">

      <!-- 博客列表 -->
          <div class="tab-pane active" id="list_article">
           <div style="padding-top: 10px">
            <a data-toggle="modal" 
               data-target="#add-blog-modal" 
               class="btn btn-info btn-sm"
               >写文章
            </a>
          <table class="table table-hover" id="blog-table">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>标题</th>
                    <th>图片</th>
                    <th>文章编号</th>
                    <th>阅读量</th>
                    <th>评论数</th>
                    <th>点赞数</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                </thead>
            <tbody>
			<%
				Page<Blog> pager = (Page<Blog>)request.getAttribute("alist");
			    if(pager !=null){
			    	List<Blog> list=pager.getItems();
					int size = list == null ? 0 : list.size();
				for(int i = 0; i < size; i++){
					Blog blog = list.get(i);
			%>
				<tr >
					<td ><%=i+1 %></td>
					<td ><%= blog.getTitle()%></td>
					<td ><%= blog.getPic_url()%>
					 <a href="">
                         <img src="<%= request.getContextPath()%>/images<%=blog.getPic_url()%>/<%=blog.getPhotoname()%>" height="30px" style="height: 30px">
                     </a>
					</td>
					<td><%= blog.getId()%></td>
					<td><%= blog.getClick_times()%></td>
					<td><%= blog.getComment_times()%></td>
					<td><%= blog.getAgree_with_times()%></td>
					<td><%= blog.getCreate_time()%></td>
					<td>
					  <div>
					  
                        <a href="<%=request.getContextPath()%>/manag/blog_detail?id=<%= blog.getId()%>">修改</a>
                        
                        
                        <a href="javascript: doDelete(<%= blog.getId()%>)">删除</a>
                      </div>
					
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
					    out.println("<a href='" + request.getContextPath() + "/blog_list?page=1'>首页</a>&nbsp;");
						if(pager.getNumber() == 1){
							out.println("<a href='javascript:;'>上一页</a>&nbsp;");
						}else{
							out.println("<a href='" + request.getContextPath() + "/blog_list?page=" + (pager.getNumber() - 1) + "'>上一页</a>&nbsp;");
						}
					
						if(pager.getNumber() == pager.getTotalPages()){
							out.println("<a href='javascript:;'>下一页</a>&nbsp;");
						}else{
							out.println("<a href='" + request.getContextPath() + "/blog_list?page=" + (pager.getNumber() + 1) + "'>下一页</a>&nbsp;");
						}
						out.println("<a href='" + request.getContextPath() + "/blog_list?page=" + pager.getTotalPages() + "'>末页</a>&nbsp;");
					%>
				</td>
			</tr>
			</tfooter>
			
			
			
		</tbody>   
    </table>
       <script type="text/javascript">
		
	</script>     
             



   </div><!--博客列表 -->
     </div>  
  </div><!-- 标签页内容 -->
    </div>
    <div class="container col-lg-2 col-md-1"></div>
  
</div><!--fluid  -->

<!--上传博客的对话框  -->
<div class="modal fade" id="add-blog-modal" tabindex="-1" role="dialog" aria-labelledby="modal-label" aria-hidden="true">
 <div class="modal-dialog">
  <div class="modal-content">
   <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">
    <span aria-hidden="true">&times;</span>
    <span class="sr-only">关闭</span>
    </button>
    <h4 class="modal-title">添加</h4>
   </div>
   <form action="<%= request.getContextPath()%>/manag/add_blog" method="post" enctype="multipart/form-data">
    <div class="modal-body">
     <div>
       <label style="font-size: 15px">标题:</label>
       <input style="display: inline;font-size:15px;width:250px;" name="title" type="text" class="form-control"/>
     </div>
     <div style="padding-top: 5px">
      <label style="font-size: 15px">分类:</label>
      <select name="type" class="form-control" style="font-size:15px;width:250px;display: inline">
       <option value="">学习</option>
       <option value="">生活</option>
       
      </select>
     </div>
     <div id="pic_div" style="padding-top: 5px;" >
       <label style="font-size: 15px">图片: </label>
       <div id="show"></div>
       <!-- 存储图片地址，并显示图片 -->
       <input type="hidden" name="pic_url" id="pictureSrc">
     </div>
     <div style="padding-top: 5px">
      <input type="file" name="photoname" id="imageFile">
     </div>
     <div style="padding-top: 10px">
      <button>时间</button>
        <input name="create_time" type="datetime" id="getBookTime">
     </div>
     <div style="padding-top: 8px">
         <textarea name="content" class="ckeditor">请输入.</textarea>
     </div>
   </div>
    <input type="hidden" name="" value="">
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
		window.location.href = "<%= request.getContextPath()%>/manag/blog_delete?id=" + id;
	}
}
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
 document.getElementById("getBookTime").value=getDate();
 }, 1000);
}  


</script>
<script src="/blog/js/ajaxfileupload.js"></script>

<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>