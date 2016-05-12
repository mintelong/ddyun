<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="大度云"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'css.css')}" type="text/css">	
		
		<script type="text/javascript" src="/ddyun/js/jquery.min.js"></script>
    	<script type="text/javascript" src="/ddyun/js/bootstrap.min.js"></script>

				
		<g:layoutHead/>
		<r:layoutResources />
		
		<header class="navbar navbar-static-top">
		    <title>大度云</title>
		    <form action='/ddyun/logout' method="post" id='logout'>
			</form>
		    <!--导航 开始-->
		    <div class="nav_box">
		        <!--导航列表 开始-->
		        <div class="nav_list">
		        	<ul>
		            	<li><a href="/ddyun"><p>首页</p><span>HOME</span></a></li>
		                <li><a href="/ddyun/index/aboutus"><p>企业时讯</p><span>INFORMATION</span></a></li>
		                <li><a href="http://139.196.197.45:8080/scrp/index"><p>智囊库</p><span>DATABASE</span></a></li>
		                <li><a href="/ddyun/index/rocfculture"><p>中国华侨</p><span>FEDERATION</span></a></li>
		                <li><a href="/ddyun/index/aboutus"><p>关于我们</p><span>ABOUT US</span></a></li>
		                
		                
		                <!-- 未登录头部 -->
			            
						
						<sec:ifLoggedIn>
		                <li>
							<a href="/ddyun/usercenter/index"><p><sec:username/></p></a>			
							<a href="##" onclick="$('#logout').submit();">退出</a>
		                </li>
		                </sec:ifLoggedIn>
		                
		                <sec:ifNotLoggedIn>
		                <li>
		                	<a href="/ddyun/login/login"><p>登录</p><span>LOGIN</span></a>	                	
		                </li>
		                <li>
		                	<a href="/ddyun/login/register"><p>注册</p><span>REGISTER</span></a>
		                </li>
		                </sec:ifNotLoggedIn>
		                
		            </ul>
		        </div>
		        <!--导航列表 结束-->
		        
		        <!--logo 开始-->
		        <div class="Logo_box"><img src="${resource(dir:'images/temp',file:'logo.png')}"/></div>
		        <!--logo 结束-->
		    </div>
		    <!--导航 结束-->
		</div>


        </header>    	
    	
    	
		
	</head>
	
	<body>	
		<g:layoutBody/>
		
		
		
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
		                    <dd><a href="http://www.gov.cn/">中国政府网</a></dd>
		                    <dd><a href="http://www.chinaql.org/sites/ql/index.html">中国侨联</a></dd>
		                    <dd><a href="http://www.shanghaiql.org/">上海侨联</a></dd>
		                </li>
		                <li><span class="mr-20">地址：上海静安区石门二路</span><i>4006123123</i></li>
		                <li>COPYRIGHT 2016上海大度云ALL RIGHT RESERVED. ALL RIGHT RESERVED. ALL RIGHT RESERVED.</li>
		            </ul>
		        </div>
		    </div>
		</div>
		</div>
		</footer>
		<!--底部版权 结束-->
		
		
		
		<r:layoutResources />
	</body>
	
	
	
</html>
