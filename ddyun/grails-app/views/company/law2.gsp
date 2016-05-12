<%@ page import="com.ddyun.company.CompanyCulture" %>
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
<div class="Coplaw_box">
    <!--左边 开始-->
    <div class="col-md-3">
    	<!--企业文化列表 开始-->
        <div class="Coplaw_list">
        	<dl>
            	<dt><i class="qicont"></i></dt>
                <dd><a href=".html">法律</a></dd>
                <dd class="on"><a href=".html"><i></i>国际法</a></dd>
                <dd><a href=".html"><i></i>国内法</a></dd>
                <dd><a href=".html">政府/非盈利机构</a></dd>
                <dd><a href=".html">政府/非盈</a></dd>
                <dd><a href=".html">政府</a></dd>
            </dl>
        </div>
        <!--企业文化列表 结束-->
        
        <!--实时信息 开始-->
        <div class="CopCul_info">
        	<dl>
            	<dt><i class="qicont"></i></dt>
                <!--循环dd 7个 开始-->
                <dd><a href=".html">上海大度云计算公司招聘精英</a></dd>
                
            </dl>
        </div>
        <!--实时信息 结束-->
    </div>
    <!--左边 结束-->
<style>

</style>
    <!--右边 开始-->
    <div class="col-md-9">
    	<div class="CopCul_cont">
        	<!--标题 开始-->
            <div class="Coplaw_top">
                <div class="Coplaw_tab">
                	<ul>
                	<!-- 
                    	<li class="on"><a href="/ddyun/company/law">企业模式</a></li>
                        <li><a href="/ddyun/company/law2">数据模式</a></li>
                         -->
                    </ul>
                </div>
                <div class="Coplaw_search">
                	<input type="text" name="" value="" class="input-text H30 WW50 radius3">
                    <input type="button" name="" value="搜索" class="btn btn-primary radius3 H30 Pd0 W55">
                    <!--搜索按钮标签可更换，只要把 class="btn btn-primary radius3 H30 Pd0 W55" 加上即可-->
                </div>
            </div>
            <!--标题 结束-->
<style>
.CoplawT_info{}
.CoplawT_info ul li{width:100%;height:120px;padding:10px 0;border-bottom:1px dashed #e2e2e2;position:relative;}
.CoplawT_img{width:185px;height:100px;position:relative;overflow:hidden;}
.CoplawT_img img{width:100%;min-height:100%;position:absolute;top:0;left:0;bottom:0;right:0;margin:auto;}
.CoplawT_text{width:100%;padding-left:200px;position:absolute;top:10px;left:0;}
.CoplawT_text h3{font-weight:600;line-height:26px;}
.CoplawT_text p{line-height:24px;color:#949494;height:70px;overflow:hidden;}
</style>
            <!--详情1 开始-->
            <div class="CoplawT_info" id="list_one">
            	<ul>
                	<!--循环li 开始-->
                <g:each in="${companyList}" var="company">
                    <li>
                    	<a href="#">
                        <div class="CoplawT_img"><img class="Pimg_hover" src="/ddyun/ddyunimg/${company.logo}"/></div>
                        <div class="CoplawT_text">
                        	<h3>${company.companyName}</h3>
                            <p>${company.companyTitle}</p>
                        </div>
                        </a>
                    </li>
                  </g:each>
                </ul>
            </div>
            <!--详情1 结束-->
            
            <!--详情2 开始-->
            <div class="Coplaw_Linfo" id="list_two" style="display:none;">
            	<ul>
                	<!--循环li  开始-->
                    <li><a href=".html"><p><i></i>中国侨联</p></a></li>
                    <!--循环li  结束-->
                    
                    <!--例 删除 开始-->
                    <!--例 删除 结束-->
                </ul>
            </div>
            <!--详情2 结束-->
        </div>
    </div>
    <!--右边 结束-->
</div>
</div>
</div>



<script type="text/javascript" src="../js/jquery.min.js"></script>
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