<!DOCTYPE html>
<%@ page import="com.ddyun.dataCenter.Words" %>
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
            	<span>留言板</span>
            </div>
            <g:form url="[resource:wordsInstance, action:'replysave']" >
            <div class="Perpaw_cont">
            	<ul>
            		<p style="display:none;"><input name="id" id="id" value="${ws.id }" /></p>
                	<li>
                        <span><i class="Required"></i>留言主题：<input name="title" id="title" value="${ws.title }" readonly="true"></input></span>
                    </li>
                    <li>
                        <span><i class="Required"></i>留言内容：
                       		  <input name="words" id="words" value="${ws.words }" readonly="true"></input>
                        </span>
                    </li>
                    <li>
                        <span><i class="Required"></i>回复：
                       		  <input name="reply" id="reply" value="" />
                        </span>
                    </li>
                    <li><g:submitButton name="replysave" class="btn btn-primary radius4" value="保存回复" /></li>                   
                </ul>
            </div>
            </g:form>
        </div>
    </div>
    <!--右边 结束-->
</div>
</div>
</div>


</body>
</html>
