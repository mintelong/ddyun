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
<div class="Ibigbg_box" style="background:url(${resource(dir:'images',file:'Ibg.png')}) center top no-repeat;">
<div class="container relative">

	<div class="Ireal_box2" ><iframe src="http://139.196.197.45/viewa.html?rpath=sf/sf14nv.cis.gz&aratio=1.7778&touch=" height="100%" width="100%" frameborder="0"></iframe></div>
  
    <!--实时状况 开始-->
    <div class="Ireal_box">
    	<div class="Ireal_border">
        	<!--标题 开始-->	
            <div class="Ireal_title"><i class="qicont"></i></div>
            <!--标题 结束-->
            
            <!--新闻内容 开始-->
            <div class="Ireal_cont">
            	<!--展示图片 开始-->
               
                <!--展示图片 结束-->
                
                <!--新闻列表 开始-->
                <div class="Ireal_text">
                	<ul>
                	<g:each status	="i" in="${newsList}" var="news">
       			    <g:if test="${  i <8}">  
                     
                  	<li><a href="/ddyun/companyNews/detail?nid=${news.id}"><p><i></i>${news.title}</p></a></li>
                  	</g:if>
                  </g:each>
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
        	<li><a href="/ddyun/company/law2"><i class="qicont"></i><p>企业导航</p></a></li>
            <li><a href="/ddyun/company/questions"><i class="qicont"></i><p>智囊库</p></a></li>
            <li><a href=".html"><i class="qicont"></i><p>资料下载</p></a></li>
            <li><a href="/ddyun/index/rocfculture"><i class="qicont"></i><p>大度商城</p></a></li>
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
        <div class="Ishow_title"><a href="/ddyun/company/pronav"><span>MORE<i></i></span></a><h3>产品展示</h3></div>
        <!--标题 结束-->
        
        <!--产品图片 开始-->
        <div class="Ishow_border">
        	<ul>
            	<!--循环li 5个 开始-->
                <li><a href="/ddyun/companyProduct/detail?pid=3"><img class="Pimg_hover" src="${resource(dir:'images',file:'专精特新领军企业.jpg')}"/></a></li>
                <!--循环li 5个 结束-->
                
                <!--例 删除 开始-->
                <li><a href="/ddyun/companyProduct/detail?pid=4"><img class="Pimg_hover" src="${resource(dir:'images',file:'上海博物馆藏国之魂宝牺尊.jpg')}"/></a></li>
                <li><a href="/ddyun/companyProduct/detail?pid=5"><img class="Pimg_hover" src="${resource(dir:'images',file:'温馨塘桥宜居生活.jpg')}"/></a></li>
                <li><a href="/ddyun/companyProduct/detail?pid=6"><img class="Pimg_hover" src="${resource(dir:'images',file:'dadulogo.png')}"/></a></li>
                <li><a href="/ddyun/companyProduct/detail?pid=7"><img class="Pimg_hover" src="${resource(dir:'images/temp',file:'case.png')}"/></a></li>
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
            	 <!--
                <li><span onclick="tabShow(this,'list_','two')">需求时讯</span></li>
                -->
            </ul>
            <a href="/ddyun/index/companynews"><span>MORE<i></i></span></a>
        </div>
        <!--选项卡 结束-->
        
        <!--新闻动态 开始-->
        <div class="Inews_list" id="list_one">
        	<ul>
       			<g:each status="i" in="${newsList}" var="news">
       			    <g:if test="${  i <8}">  
                     
                  	<li><a href="/ddyun/companyNews/detail?nid=${news.id}"><p><i></i>${news.title}</p></a></li>
                  	</g:if>
                  </g:each>
            </ul>
        </div>
        <!--新闻动态 结束-->
        
        <!--需求时讯 开始-->
        <div class="Inews_list" id="list_two" style="display:none;">
        	<ul>
            	<g:each in="${newsList}" var="news">
                 	<li><a href="/ddyun/companyNews/detail?nid=${news.id}"><p><i></i>${news.title}</p></a></li>
                 </g:each>
            </ul>
        </div>
        <!--需求时讯 结束-->
    </div>
</div>
</div>


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
