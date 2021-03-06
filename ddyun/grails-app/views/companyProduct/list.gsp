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
                <dd><a href="/ddyun/usercenter/index">我的信息</a></dd>
                <dd><a href="/ddyun/companyCase/list">合作案例</a></dd>
                <dd><a href="/ddyun/companyCulture/list">入驻企业</a></dd>
                <dd><a href="/ddyun/companyElite/list">企业精英</a></dd>
                <dd><a href="/ddyun/companyNews/list">企业新闻</a></dd>
                <dd class="on"><a href="/ddyun/companyProduct/list">企业产品</a></dd>
              
                <dd><a href="/ddyun/companyContact/list">联系我们</a></dd>
            </dl>
        </div>
        <!--企业文化列表 结束-->
    </div>
    <!--左边 结束-->

    <!--右边 开始-->
    <div class="col-md-9">
    	<div class="CopCul_cont">
        	<div class="line2">
            	<g:link controller="companyProduct" action="create"><span>添加</span></g:link>
            </div>
            <div class="PerRel_myinfo">
            	<table class="table table-bordered">
                	<thead>
                    	<tr bgcolor="#f5f5f5">
                        	<th>产品名称</th>
                        	<th>产品标题</th>
                        	<th>价格</th>
                            <th>图片</th>
                            <th>添加日期</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<!--循环li 开始-->
                    	<g:each in="${lists}" var="company">
                    		<tr>
	                        	<td>${company.name}</td>
	                        	<td>${company.title}</td>
	                        	<td>${company.price}</td>
	                            <td><img src="/ddyun/ddyunimg/${company.logo}" width="40" height="40"/></td>
	                            <td><g:formatDate date="${company.date}" format="yyyy-MM-dd HH:mm:ss"/></td>
	                            <td><g:link controller="companyProduct" action="delete" params='[id:"${company.id}"]'>删除</g:link></td>
                        	</tr>
                    	</g:each>
                        
                        <!--循环li 结束-->
                    </tbody>
                </table>
            </div>
            <!-- div class="PerRel_btn"><a href="#">查看更多+</a></div-->
        </div>
    </div>
    <!--右边 结束-->
</div>
</div>
</div>


</body>
</html>
