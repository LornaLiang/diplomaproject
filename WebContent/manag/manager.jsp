<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page language="java" import="java.util.*" %>
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
<div class="container" style="padding: 100px 50px 10px;" >
	<button type="button" class="btn btn-default" title="Popover title"  
			data-container="body" data-toggle="popover" data-placement="left" 
			data-content="左侧的 Popover 中的一些内容">
		左侧的 Popover
	</button>
	<button type="button" class="btn btn-primary" title="Popover title"  
			data-container="body" data-toggle="popover" data-placement="top" 
			data-content="顶部的 Popover 中的一些内容">
		顶部的 Popover
	</button>
	<button type="button" class="btn btn-success" title="Popover title"  
			data-container="body" data-toggle="popover" data-placement="bottom" 
			data-content="底部的 Popover 中的一些内容">
		底部的 Popover
	</button>
	<button type="button" class="btn btn-warning" title="Popover title"  
			data-container="body" data-toggle="popover" data-placement="right" 
			data-content="右侧的 Popover 中的一些内容">
		右侧的 Popover
	</button>
</div>
<script>
$(function () { 
	$("[data-toggle='popover']").popover();
});
</script>


<!--图片轮播  -->
 <div id="ad-carousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
            <li data-target="#ad-carousel" data-slide-to="1"></li>
            <li data-target="#ad-carousel" data-slide-to="2"></li>
         </ol>
        <div class="carousel-inner">
            <div class="item active">
                <img src="images/index1.jpg" alt="1 slide">              
            </div>
            <div class="item">
                <img src="images/index2.jpg" alt="2 slide">               
            </div>
            <div class="item">
                <img src="images/index3.jpg" alt="3 slide">               
            </div>                      
        </div>
        <a class="left carousel-control" href="#ad-carousel" data-slide="prev"><span
                class="glyphicon glyphicon-chevron-left"></span></a>
        <a class="right carousel-control" href="#ad-carousel" data-slide="next"><span
                class="glyphicon glyphicon-chevron-right"></span></a>
    </div>











<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/2.1.1/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>