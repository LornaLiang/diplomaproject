<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="cn.cat.entity.Album" %>
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

 
 <div class="row-fluid container" style="text-align: center">
     
        <hr>
         <%
             Page<Album> pager = (Page<Album>)request.getAttribute("list");		
             if(pager !=null){
			    	List<Album> list=pager.getItems();
					int size = list == null ? 0 : list.size();	
      				for(int i = 0; i < size; i++){
					Album album = list.get(i);
			%>
        <div class="col-xs-3 col-md-3 col-lg-3">
            
           <img src="<%= request.getContextPath()%>/images<%=album.getUrl()%>/<%=album.getPhotoname()%>" alt="..." height="180px" style="height: 180px">
            
            <div class="caption">
                <div><label><%=album.getTitle()%>  </label></div>
            </div>
          </div>
           <% 
				}
			}
			%>  
        
    	
</div>
 

<tfooter>
			<tr>
				<td colspan="6">共 <%=pager.getTotalElements()%>条, 共<%= pager.getTotalPages()%>页,
					当前是第<%= pager.getNumber() %>页&nbsp;&nbsp;&nbsp; <%
					    out.println("<a href='" + request.getContextPath() + "/web_album_list?page=1'>首页</a>&nbsp;");
						if(pager.getNumber() == 1){
							out.println("<a href='javascript:;'>上一页</a>&nbsp;");
						}else{
							out.println("<a href='" + request.getContextPath() + "/web_album_list?page=" + (pager.getNumber() - 1) + "'>上一页</a>&nbsp;");
						}
					
						if(pager.getNumber() == pager.getTotalPages()){
							out.println("<a href='javascript:;'>下一页</a>&nbsp;");
						}else{
							out.println("<a href='" + request.getContextPath() + "/web_album_list?page=" + (pager.getNumber() + 1) + "'>下一页</a>&nbsp;");
						}
						out.println("<a href='" + request.getContextPath() + "/web_album_list?page=" + pager.getTotalPages() + "'>末页</a>&nbsp;");
					%>
				</td>
			</tr>
			</tfooter>	

<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>