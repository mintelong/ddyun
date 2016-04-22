<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<title></title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'css.css')}" type="text/css">

</head>

<body>
<div class="Ibigbg_box" style="background:url(${resource(dir:'images',file:'Ibg.png')}) center top no-repeat;">
<div class="container relative">
<div class="row">
	<!--登录注册 开始-->
    <div class="Ilogin_box">
    	<a href=".html">登录</a>
        <a href=".html">注册</a>
        <i>02131668970</i>
	</div>
    <!--登录注册 结束-->
    
    <!--导航 开始-->
    <div class="nav_box">
        <!--导航列表 开始-->
        <div class="nav_list">
        	<ul>
            	<li><a href="index.html"><p>首页</p><span>HOME</span></a></li>
                <li><a href=".html"><p>企业时讯</p><span>INFORMATION</span></a></li>
                <li><a href=".html"><p>智囊库</p><span>DATABASE</span></a></li>
                <li><a href=".html"><p>中国华侨</p><span>FEDERATION</span></a></li>
                <li><a href=".html"><p>关于我们</p><span>ABOUT US</span></a></li>
            </ul>
        </div>
        <!--导航列表 结束-->
        
        <!--logo 开始-->
        <div class="Logo_box"><img src="${resource(dir:'images/temp',file:'logo.png')}"/></div>
        <!--logo 结束-->
    </div>
    <!--导航 结束-->
    
    <!--实时状况 开始-->
    <div class="Ireal_box">
    	<div class="Ireal_border">
        	<!--标题 开始-->
            <div class="Ireal_title"><i class="qicont"></i></div>
            <!--标题 结束-->
            
            <!--新闻内容 开始-->
            <div class="Ireal_cont">
            	<!--展示图片 开始-->
                <div class="Ireal_img"><img src="${resource(dir:'images',file:'road.png')}"/></div>
                <!--展示图片 结束-->
                
                <!--新闻列表 开始-->
                <div class="Ireal_text">
                	<ul>
                    	<!--循环li 6条 开始-->
                        <li><a href=".html"><p><i></i>某集团4入驻该平台某集团4入驻该平台</p><span>04-10</span></a></li>
                        <!--循环li 6条 结束-->
                        
                        <!--例 删除 开始-->
                        <li><a href=".html"><p><i></i>某集团4入驻该平台某集团4入驻该平台</p><span>04-10</span></a></li>
                        <li><a href=".html"><p><i></i>某集团4入驻该平台某集团4入驻该平台</p><span>04-10</span></a></li>
                        <li><a href=".html"><p><i></i>某集团4入驻该平台某集团4入驻该平台</p><span>04-10</span></a></li>
                        <li><a href=".html"><p><i></i>某集团4入驻该平台某集团4入驻该平台</p><span>04-10</span></a></li>
                        <li><a href=".html"><p><i></i>某集团4入驻该平台某集团4入驻该平台</p><span>04-10</span></a></li>
                        <!--例 删除 结束-->
                    </ul>
                </div>
                <!--新闻列表 结束-->
            </div>
            <!--新闻内容 结束-->
        </div>
    </div>
    <!--实时状况 结束-->
    
    <!--圆圈导航 开始-->
    <div class="Iround_box">
    	<ul>
        	<li><a href=".html"><i class="qicont"></i><p>企业导航</p></a></li>
            <li><a href=".html"><i class="qicont"></i><p>智囊库</p></a></li>
            <li><a href=".html"><i class="qicont"></i><p>资料下载</p></a></li>
            <li><a href=".html"><i class="qicont"></i><p>中国侨联</p></a></li>
            <li><a href=".html"><i class="qicont"></i><p>常用工具</p></a></li>
        </ul>
    </div>
    <!--圆圈导航 结束-->
</div>
</div>
</div>

<div class="container mt-30">
<div class="row">
	<!--产品展示 开始-->
    <div class="Ishow_box">
    	<!--标题 开始-->
        <div class="Ishow_title"><a href=".html"><span>MORE<i></i></span></a><h3>产品展示</h3></div>
        <!--标题 结束-->
        
        <!--产品图片 开始-->
        <div class="Ishow_border">
        	<ul>
            	<!--循环li 5个 开始-->
                <li><a href=".html"><img class="Pimg_hover" src="${resource(dir:'images/temp',file:'case.png')}"/></a></li>
                <!--循环li 5个 结束-->
                
                <!--例 删除 开始-->
                <li><a href=".html"><img class="Pimg_hover" src="${resource(dir:'images/temp',file:'case.png')}"/></a></li>
                <li><a href=".html"><img class="Pimg_hover" src="${resource(dir:'images/temp',file:'case.png')}"/></a></li>
                <li><a href=".html"><img class="Pimg_hover" src="${resource(dir:'images/temp',file:'case.png')}"/></a></li>
                <li><a href=".html"><img class="Pimg_hover" src="${resource(dir:'images/temp',file:'case.png')}"/></a></li>
                <!--例 删除 结束-->
            </ul>
        </div>
        <!--产品图片 结束-->
    </div>
    <!--产品展示 结束-->
    
    <div class="Inews_box">
    	<!--选项卡 开始-->
        <div class="Inews_tab">
        	<ul>
            	<li class="on"><span onclick="tabShow(this,'list_','one')">新闻动态</span></li>
                <li><span onclick="tabShow(this,'list_','two')">需求时讯</span></li>
            </ul>
            <a href=".html"><span>MORE<i></i></span></a>
        </div>
        <!--选项卡 结束-->
        
        <!--新闻动态 开始-->
        <div class="Inews_list" id="list_one">
        	<ul>
            	<!--循环li 8个 开始-->
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <!--循环li 8个 结束-->
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
            </ul>
        </div>
        <!--新闻动态 结束-->
        
        <!--需求时讯 开始-->
        <div class="Inews_list" id="list_two" style="display:none;">
        	<ul>
            	<!--循环li 8个 开始-->
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东11111111</p></a></li>
                <!--循环li 8个 结束-->
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
                <li><a href=".html"><p><i></i>山东确定十大优势产业 打造"山东 山东确定十大优势产业山东确定十大优势产业山东确定十大优势产业</p></a></li>
            </ul>
        </div>
        <!--需求时讯 结束-->
    </div>
</div>
</div>

<!--底部版权 开始-->
<footer class="mt-50">
<div class="container">
<div class="row">
	<div class="foot_box">
    	<div class="foot_logo"><img src="${resource(dir:'images/temp',file:'logo.png')}"/></div>
        <div class="foot_copy">
        	<ul>
            	<li>
                	<span>友情链接：</span>
                    <dd><a href=".html">友情链接1</a></dd>
                    <dd><a href=".html">友情链接2</a></dd>
                    <dd><a href=".html">友情链接3</a></dd>
                </li>
                <li><span class="mr-20">地址：上海xxxxxxxxxxxxxxxxxxxxxx</span><i>4006123123</i></li>
                <li>COPYRIGHT 2016上海大度云ALL RIGHT RESERVED. ALL RIGHT RESERVED. ALL RIGHT RESERVED.</li>
            </ul>
        </div>
    </div>
</div>
</div>
</footer>
<!--底部版权 结束-->

<script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.min.js')}" ></script>
<script>
function tabShow(obj,prex,num){
	//选项卡样式变化
	$(obj).parent().siblings().each(function(){
		$(this).removeClass('on');
	});
	$(obj).parent().addClass('on');
	
	//对应内容变化
	$('[id^='+ prex +']').each(function(){
		$(this).css('display','none');
	})
	$('#'+ prex + num ).css('display','block')	
}
</script>
</body>
</html>
