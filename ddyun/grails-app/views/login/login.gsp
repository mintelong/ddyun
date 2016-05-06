<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<title>登陆</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'css.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'user.css')}" type="text/css">

</head>

<body>
<div class="Ibigbg_box" style="background:url(${resource(dir:'images',file:'rock.png')}) no-repeat center;">
<div class="container">
<div class="row">
    
    <!--导航 开始-->
    <div class="nav_box">
        <!--导航列表 开始-->
        <div class="nav_list">
        	<ul>
            	<li><a href="index#"><p>首页</p><span>HOME</span></a></li>
                <li><a href=".html"><p>企业时讯</p><span>INFORMATION</span></a></li>
                <li><a href=".html"><p>智囊库</p><span>DATABASE</span></a></li>
                <li><a href=".html"><p>中国华侨</p><span>FEDERATION</span></a></li>
                <li><a href=".html"><p>关于我们</p><span>ABOUT US</span></a></li>
            </ul>
        </div>
        <!--导航列表 结束-->
        
        <!--logo 开始-->
        <div class="Logo_box"><img src="${resource(dir:'images/temp',file:'logo.png')}"></div>
        <!--logo 结束-->
    </div>
    <!--导航 结束-->
</div>
</div>
</div>
<div class="container">
<div class="row">
<div class="RocfCul_box">
	<div class="LoginB bgff pt-30 radius4">
		<div class="col-md-6">
			<div class="tl"><span>个人登陆</span> 还没有账号？<u><a href="/ddyun/login/register">立刻注册</a></u></div>
		
			<div class="form clear form-horizontal mt-50 pb-50">
				<form action='${postUrl}' method='post' id='login_form'>
				<ul>
					<li><label class="form-label col-2"><span class="c-red">*</span>用户名：</label><input type="text" name='j_username' id='username' class="input-text H35 W280" value="" placeholder=""></li>
					<li><label class="form-label col-2"><span class="c-red">*</span>密码：</label><input type="password" name='j_password' id='password' class="input-text H35 W280" value="" placeholder=""></li>
					<!--li><label class="form-label col-2"><span class="c-red">*</span>验证码：</label><input type="text" class="input-text H35 W160" value="" placeholder="" ><img style="vertical-align:middle; max-height:35px; overflow:hidden;" src="${resource(dir:'images/temp',file:'0.jpg')}" /></li-->
					
					<div style="margin-left:200px; margin-top:20px;">
						<button type="submit" class="btn2 btn-warning IH35 W160 mr-20">登陆</button><span><a href="#" target="_blank">找回密码</a></span>
					</div>
				</ul>
				</form>
				<div style="margin-left:200px;" class="HelpTel mt-30">咨询电话：012012-225002</div>
			</div>
		</div>
		<div class="col-md-6">
			<img src="${resource(dir:'images',file:'loginB.jpg')}" />
		</div>
		
		<div class="clear"></div>
	</div>
</div>
</div>

<!--底部版权 开始-->
<footer class="mt-50">
<div class="container">
<div class="row">
	<div class="foot_box">
    	<div class="foot_logo"><img src="${resource(dir:'images/temp',file:'logo.png')}"></div>
        <div class="foot_copy">
        	<ul>
            	<li>
                	<span>友情链接：</span>
                    <dd><a href=".html">友情链接1</a></dd>
                    <dd><a href=".html">友情链接2</a></dd>
                    <dd><a href=".html">友情链接3</a></dd>
                </li>
                <li><span class="mr-20">地址：山东xxxxxxxxxxxxxxxxxxxxxx</span><i>4006123123</i></li>
                <li>COPYRIGHT 2016山东极站网络科技ALL RIGHT RESERVED. ALL RIGHT RESERVED. ALL RIGHT RESERVED.</li>
            </ul>
        </div>
    </div>
</div>
</div>
</footer>
<!--底部版权 结束-->
</body>
</html>