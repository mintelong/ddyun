<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>

<body>
<div class="Ibigbg_box" style="background:url(../images/companybg.png) no-repeat center;">
<div class="container">

</div>
</div>

<div class="container">
<div class="row">
<div class="CopCul_box">

    <!--右边 开始-->
    <div class="col-md-9">
    	<div class="CopCul_cont">
        	<!--标题 开始-->
            <div class="CopCul_title">
                <a href="/ddyun">返回首页</a>
                <h3>新闻详情</h3>
            </div>
            <!--标题 结束-->
            
            <!--详情 开始-->
            <div class="CopCnect_box">
            	<label>${news.title}</label>
            	<img src="../ddyunimg/${news.logo}" width="500" height="400" />
                <p><i></i>${news.content}</p> 
                   
            </div>
           
            <!--详情 结束-->
        </div>
    </div>
    <!--右边 结束-->
</div>
</div>
</div>


</body>
</html>