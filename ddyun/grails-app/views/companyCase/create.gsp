<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'companyCase.label', default: 'CompanyCase')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
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
		                <dd class="on"><a href="/ddyun/companyCase/list">合作案例</a></dd>
		                <dd><a href="/ddyun/companyCulture/list">企业文化</a></dd>
		                <dd><a href="/ddyun/companyElite/list">企业精英</a></dd>
		                <dd><a href="/ddyun/companyNews/list">企业新闻</a></dd>
		                <dd><a href="/ddyun/companyProduct/list">企业产品</a></dd>
		                <dd><a href="/ddyun/rocfCulture/list">侨联文化</a></dd>
		                <dd><a href="/ddyun/rocfLeader/list">侨联领导</a></dd>
		                <dd><a href="/ddyun/rocfNews/list">侨联新闻</a></dd>
		                <dd><a href="/ddyun/rocfWord/list">中国侨联</a></dd>
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
		            	<span></span>
		            </div>
		            <g:uploadForm id="companyForm" url="[resource:companyCaseInstance, action:'save']" >
			            <div class="PerRel_cont">
			            	<ul>
			                	<li>
			                        <span><i class="Required">*</i>产品名称：
			                        	<input type="text" name="name" id="name" value="">
			                        </span>
			                    </li>
			                    <li>
			                        <span><i class="Required">*</i>产品描述：
			                        	<input type="text" name="describe" id="describe" value="">
			                        </span>
			                    </li>
			                    <li>
			                        <span><i class="Required">*</i>产品图片：
			                        	<input type="file" name="logo" id="logo" value="">
			                        </span>        
			                    </li>
			                    <li>
			                    	<g:select id="companyId" name="companyId" from="${com.ddyun.company.CompanyCulture.list()}" optionKey="id" required="" value="" class="many-to-one"/>
			                    </li>
			                    <li><button onclick="submitForm()" class="btn btn-primary radius4">保存</button></li>
			                </ul>
			            </div>
		            </g:uploadForm>
		        </div>
		        
		    </div>
		    <!--右边 结束-->
		</div>
		</div>
		</div>
		
		
		
		
		
		
		
	<script type="text/javascript">

	function submitForm(){	
		$("companyForm").submit();
	}
	
	</script>	

		
	</body>
</html>