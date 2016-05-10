<div class="left-navi">
	<div class="module-list">
		<sec:ifAnyGranted roles="ROLE_ADMIN">
			<div class="module-title">
				<span class="icon data"></span>官网管理
			</div>
			<a class="module-link" href="/scfire/manage/listBannerPc">首页</a>
			<a class="module-link" href="/scfire/manage/listArticlePc">文章管理</a>
			<a class="module-link" href="/scfire/manage/listPartnerPc">伙伴管理</a>
			<a class="module-link" href="/scfire/manage/listDiary">创业日记</a>
			<a class="module-link" href="/scfire/manage/editAbout">内容管理</a>
			<div class="module-title">
				<span class="icon data"></span>首页管理
			</div>
			<a class="module-link" href="/scfire/manage/index">项目推送</a>
			<a class="module-link" href="/scfire/manage/banner">海报管理</a>
			<div class="module-title">
				<span class="icon cube"></span>项目审核管理
			</div>
			<a class="module-link"
				href="/scfire/manage/projectApproveStatus?status=wait">待审核</a>
			<a class="module-link"
				href="/scfire/manage/projectApproveStatus?status=pass">审核通过</a>
			<a class="module-link"
				href="/scfire/manage/projectApproveStatus?status=refuse">审核拒绝</a>
				
			<div class="module-title">
				<span class="icon cube"></span>实名认证管理
			</div>
			<a class="module-link"
				href="/scfire/manage/userApproveStatus?status=wait">待审核</a>
			<a class="module-link"
				href="/scfire/manage/userApproveStatus?status=pass">审核通过</a>
			<a class="module-link"
				href="/scfire/manage/userApproveStatus?status=refuse">审核拒绝</a>
			<div class="module-title">
				<span class="icon cube"></span>用户管理
			</div>
			<a class="module-link" href="/scfire/manage/userInfoReport">用户管理</a>
			<div class="module-title">
				<span class="icon cube"></span>爱心池管理
			</div>
			<a class="module-link" href="/scfire/manage/listFund">管理爱心池</a>
			<div class="module-title">
				<span class="icon cube"></span>报表管理
			</div>
			<a class="module-link" href="/scfire/manage/donateReport">捐赠报表</a>
			<div class="module-title">
				<span class="icon cube"></span>微信管理
			</div>
			<a class="module-link" href="/scfire/manage/createMainMenu">自定义菜单</a>
			<a class="module-link" href="/scfire/manage/manageAutoReply">自动回复</a>
			
			<div class="module-title">
				<span class="icon cube"></span>项目管理
			</div>
			<a class="module-link"
				href="/scfire/manage/projectManage">项目管理</a>
			<div class="module-title">
				<span class="icon cube"></span>财务管理
			</div>
			<a class="module-link" href="/scfire/manage/donateDetail">捐赠明细</a>
			<a class="module-link" href="/scfire/manage/listFundPoolDetail">爱心池明细</a>
			<a class="module-link" href="/scfire/manage/listProjectFeeDetail">项目筹款明细</a>
			<!-- 
			<div class="module-title">
				<span class="icon cube"></span>春节活动
			</div>
			
			<a class="module-link" href="/scfire/manage/showRedEnvelopeTicket">春节红包</a>
			-->
		</sec:ifAnyGranted>
	</div>
</div>

