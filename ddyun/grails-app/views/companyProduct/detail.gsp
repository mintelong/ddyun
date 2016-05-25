<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<title>大度云</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>

<body>
<div class="Ibigbg_box" style="background:url(${resource(dir:'images',file:'companybg.png')}) no-repeat center;">
<div class="container">
<div class="row">
	
</div>
</div>
</div>

<div class="container">
<div class="row">
<div class="CopCul_box">
    <!--右边 开始-->
    <div class="col-md-12">
    	<div class="CopCul_cont">
        	<!--标题 开始-->
            <div class="CopCul_title">
                <a href="/ddyun">返回首页</a>
                <h3>产品详情</h3>
            </div>
            <!--标题 结束-->

            <!--产品列表 开始-->
            <div class="ProNav_box">
            	<ul>
                	<!--循环li 最多12个多的分页 开始-->
                    <li>
                        <div class="ProNav_cont">
                        <p>${product.name}</p>
                        <a href="#">
                       	 <img src="../ddyunimg/${product.logo}" width="400" height="300">
                       	  </a>
                       	  <p>${product.title}</p>
                       	  <p>价格：￥${product.price}</p>
                        </div>
                    </li>
                    
                    
                    <!--例 删除 结束-->
                </ul>
            </div>
            <!--产品列表 结束-->
            
            
        </div>
    </div>
    <!--右边 结束-->
</div>
</div>
</div>



</body>
</html>