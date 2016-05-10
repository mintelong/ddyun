<%@ page import="com.ddyun.company.CompanyCase" %>

<link rel="stylesheet" href="${resource(dir: 'css', file: 'user.center.css')}" type="text/css">
<script type="text/javascript" src="${resource(dir: 'js', file: 'jquery-1.10.2.js')}"></script>
<script type="text/javascript" src="${resource(dir: 'js', file: 'ajaxfileupload.js')}"></script>

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
                <dd><a href="/ddyun/usercenter/index">用户中心</a></dd>
                <dd class="on"><a href="/ddyun/companyCase/create">公司产品</a></dd>
                <dd><a href="/ddyun/usercenter/mymessage">我的信息</a></dd>
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
            <div class="PerRel_cont">
            	<ul>
                	<li>
                        <span><i class="Required">*</i>产品名称：
                        	<input type="text" name="name" id="" value="">
                        </span>
                    </li>
                    <li>
                        <span><i class="Required">*</i>产品图片：
                        	<input type="file" name="logo" id="logo" value="">
                        </span>
                        
                        
                        <!--div class="form-item fix-width">
                            <div class="form-tips"></div>
                            <div class="form-ctrl">
                                <div class="img-box btn o no-border">
                                    +
                                    <input type="file" class="upload-cover" name="img-p" id="img-p">
                                </div>
                                <input type="hidden" name="img" id="img">
                            </div>
                        </div-->
                        
                        
                    </li>
                    <li><a href="#" class="btn btn-primary radius4">保存</a></li>
                </ul>
            </div>
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    </div>
    <!--右边 结束-->
</div>
</div>
</div>

<script type="text/javascript">

function upload(){

		$.ajaxFileUpload({  
			url:'/image/imgSave',  
			secureuri:false,  
			dataType:'text',
			fileElementId:file,//file标签的id 
			success: function (data, status) { 
	        	if(data=='large'){
	        		showWarn('图片过大');
	        		return;
	        	}
	    		if(data=='format'){
	        		showWarn('图片格式不对');
	        		return;
	        	}
	           //把图片替换  
	           if(data=='fail'){
	           		showWarn('上传失败');
	           }else{
	        	   //图片预览
	        	   
	        	   console.log("return:"+data);
	               var imageurl = "/scfire/project/imgRead?img="+data;	                   
	               //图片地址赋值给后台
	               $("#img").val(data);  
	               
	               $("#imgshow").css('background-image', 'url(' + imageurl + ')');
	       
	           }
	       },  
	       error: function (data, status, e) {  
	       },
	      
	});
	
}

</script>
