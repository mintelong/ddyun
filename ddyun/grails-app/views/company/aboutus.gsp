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
    <!--左边 开始-->
    <div class="col-md-3">
    	<!--企业文化列表 开始-->
        <div class="CopCul_list">
        	<dl>
            	<dt><i class="qicont"></i></dt>
                <dd class="on"><a href="/ddyun/company/aboutus?uid=${user.id}">企业文化</a></dd>
                <dd><a href="/ddyun/company/companyelite/list2">企业精英</a></dd>
                <dd><a href="/ddyun/company/companyproduct/list2">企业产品</a></dd>
                <dd><a href="/ddyun/company/companycase/list2">合作案例</a></dd>
                <dd><a href="/ddyun/company/companywork/list2">业务范围</a></dd>
                <dd><a href="/ddyun/company/companyconnect">联系我们</a></dd>
                <dd><a href="/ddyun/company/companynews/list2">最新消息</a></dd>
            </dl>
        </div>
        <!--企业文化列表 结束-->
        
        <!--实时信息 开始-->
        <div class="CopCul_info">
        	<dl>
            	<dt><i class="qicont"></i></dt>
                <!--例 删除 开始-->
                <dd><a href="/ddyun/index/companynewsdt">上海大度云计算公会招聘精英</a></dd>
                <!--例 删除 结束-->
            </dl>
        </div>
        <!--实时信息 结束-->
        
        <!--留言版 开始-->
        <div class="CopCul_liuyan">
        	<a href=".html">留言板</a>
        </div>
        <!--留言版 开始-->
        
        <!--导航 开始-->
        <div class="CopCul_nav">
        	<ul>
            	<li><a href=".html"><i class="qicont"></i><p>智囊库</p></a></li>
                <li><a href=".html"><i class="qicont"></i><p>资料下载</p></a></li>
                <li><a href=".html"><i class="qicont"></i><p>常用工具</p></a></li>
            </ul>
        </div>
        <!--导航 结束-->
    </div>
    <!--左边 结束-->

    <!--右边 开始-->
    <div class="col-md-9">
    	<div class="CopCul_cont">
        	<!--标题 开始-->
            <div class="CopCul_title">
                <a href="/ddyun">返回首页</a>
                <h3>企业文化</h3>
            </div>
            <!--标题 结束-->
            
            <!--详情 开始-->
            <div class="CopCnect_box">
            	<label>${cc.companyTitle}</label>
            	<img src="../ddyunimg/${cc.logo}" width="400" height="300" />
                <p>${cc.companyCultureContent}</p>         
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