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
                <dd><a href="/ddyun/companyCulture/list">企业文化</a></dd>
                <dd><a href="/ddyun/companyElite/list">企业精英</a></dd>
                <dd><a href="/ddyun/companyNews/list">企业新闻</a></dd>
                <dd><a href="/ddyun/companyProduct/list">企业产品</a></dd>
                <dd><a href="/ddyun/rocfCulture/list">侨联文化</a></dd>
                <dd><a href="/ddyun/rocfLeader/list">侨联领导</a></dd>
                <dd><a href="/ddyun/rocfNews/list">侨联新闻</a></dd>
                <dd><a href="/ddyun/rocfWord/list">中国侨联</a></dd>
                <dd class="on"><a href="/ddyun/companyContact/list">联系我们</a></dd>
            </dl>
        </div>
        <!--企业文化列表 结束-->
    </div>
    <!--左边 结束-->

    <!--右边 开始-->
    <div class="col-md-9">
    	<div class="CopCul_cont">
        	<div class="line2">
            	<g:link controller="companyContact" action="create"><span>添加</span></g:link>
            </div>
            <div class="PerRel_myinfo">
            	<table class="table table-bordered">
                	<thead>
                    	<tr bgcolor="#f5f5f5">
                        	<th>电话</th>
                        	<th>地址</th>
                            <th>负责人</th>
                            <th>邮箱</th>
                            <th>添加日期</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<!--循环li 开始-->
                    	<g:each in="${lists}" var="company">
                    		<tr>
	                        	<td>${company.tel}</td>
	                        	<td>${company.address}</td>
	                            <td>${company.officer}</td>
	                            <td>${company.email}</td>
	                            <td><g:formatDate date="${company.date}" format="yyyy-MM-dd HH:mm:ss"/></td>
	                            <td><g:link controller="companyContact" action="delete" params='[id:"${company.id}"]'>删除</g:link></td>
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
