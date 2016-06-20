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
<div class="RocfCul_box">
    <!--左边 开始-->
    <div class="col-md-3">
    	<!--企业文化列表 开始-->
        <div class="RocfCul_list">
        	<dl>
            	<dt><em class="qicont"></em></dt>
                <dd class="on"><a href="/ddyun/usercenter/index">用户中心</a></dd>
                <dd><a href="/ddyun/companyCase/list">企业信息上传</a></dd>
                <dd><a href="http://139.196.197.45:8080/hscsp/">需求信息发布</a></dd>
                
            </dl>
        </div>
        <!--企业文化列表 结束-->
    </div>
    <!--左边 结束-->

    <!--右边 开始-->
    <div class="col-md-9">
    	<div class="CopCul_cont">
        	<div class="line2">
            	<span>个人资料</span>
            </div>
            <div class="Perpaw_cont">
            	<ul>
                	<li>
                        <span><i class="Required">*</i>用户名：${user.username}</span>
                    </li>
                    <li>
                        <span><i class="Required">*</i>密码：
                       		  <input type="password" name="password" id="password" value="${user.password}">
                        </span>
                    </li>
                    <li><a href="#" class="btn btn-primary radius4">保存</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!--右边 结束-->
</div>
</div>
</div>


</body>
</html>
