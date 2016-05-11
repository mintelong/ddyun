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
            	<dd><a href="/ddyun/company/aboutus">企业文化</a></dd>
                <dd><a href="/ddyun/company/companyelite">企业精英</a></dd>
                <dd><a href="/ddyun/company/companyproduct">企业产品</a></dd>
                <dd class="on"><a href="/ddyun/company/companycase">合作案例</a></dd>
                <dd><a href="/ddyun/company/companywork">业务范围</a></dd>
                <dd><a href="/ddyun/company/companyconnect">联系我们</a></dd>
                <dd><a href="/ddyun/company/companynews">最新消息</a></dd>
            </dl>
        </div>
        <!--企业文化列表 结束-->
        
        <!--实时信息 开始-->
        <div class="CopCul_info">
        	<dl>
            	<dt><i class="qicont"></i></dt>
                <!--循环dd 7个 开始-->
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
                <a href="index.html">返回首页</a>
                <h3>合作案例</h3>
            </div>
            <!--标题 结束-->

            <!--产品列表 开始-->
            <div class="ComCase_box">
            	<ul>
            	<g:each in="${lists}" var="companyCase">
            	<li>
            	
                        <div class="ComCase_cont">
                        	<a href="http://139.196.197.45/viewa.html?rpath=oca/oca_4.cis.gz&touch=">
                        	<img src="${companyCase.logo}">
                        	</a>
                        </div>
                    </li>
                   </g:each> 
            	
                	<!--循环li 最多12个多的分页 开始-->
                    <li>
                        <div class="ComCase_cont">
                        	<a href="http://139.196.197.45/viewa.html?rpath=oca/oca_4.cis.gz&touch=">
                        	<img src="../images/专精特新领军企业.jpg">
                        	</a>
                        </div>
                    </li>
                    <!--循环li 最多12个多的分页 结束-->
                    
                    <!--例 删除 开始-->
                    <li>
                        <div class="ComCase_cont">
                           <a href="http://139.196.197.45/viewa.html?rpath=oca/oca_4.cis.gz&touch=">
                      
                        	<img src="../images/上海博物馆藏国之魂宝牺尊.jpg">
                        	</a>
                        </div>
                    </li>
                    <li>
                        <div class="ComCase_cont">
                           <a href="http://139.196.197.45/viewa.html?rpath=oca/oca_4.cis.gz&touch=">
                      
                        	<img src="../images/温馨塘桥宜居生活.jpg">
                        	</a>
                        </div>
                    </li>
                    
                    <!--例 删除 结束-->
                </ul>
            </div>
            <!--产品列表 结束-->
            
            <!--分页 开始-->
            <div class="Elite_page">
            	<div class="Elite_line"></div>
                <ul>
                	<li><a href=".html">首页</a></li>
                    <!--上一页 开始-->
                    <li><a href=".html"><</a></li>
                    <!--上一页 结束-->
                    
                    <!--页数 开始-->
                    <li class="on"><a href=".html">1</a></li>
                    <li><a href=".html">2</a></li>
                    <!--页数 结束-->
                    
                    <!--下一页 开始-->
                    <li><a href=".html">></a></li>
                    <!--下一页 结束-->
                    <li><a href=".html">末页</a></li>
                </ul>
            </div>
            <!--分页 结束-->
        </div>
    </div>
    <!--右边 结束-->
</div>
</div>
</div>

</body>
</html>