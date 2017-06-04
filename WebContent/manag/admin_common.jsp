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
<title></title>

<style>

</style>
</head>
<body>
<!-- 顶部导航 -->
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="<%= request.getContextPath()%>/web_blog_list">返回博客</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#" data-toggle="modal" data-target="#about-modal">关于</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->

    
</nav>

<!-- 关于 -->
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
                        <img src="../images/head.jpg" width="100px" height="100px" class="img-circle">
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




<!-- jquery要在bootstrap之前引入 -->
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>