//date-href地址解析
$('body').on("click" ,".Clickhref,.Clickhref li", function(){
		if($(this).data('href')){
			location.href= $(this).data('href');
		}
	});
	$('.btn_home').click(function(){
		location.href= '/';
});
/*异步加载图片*/
window.Echo=(function(window,document,undefined){'use strict';var store=[],offset,throttle,poll;var _inView=function(el){var coords=el.getBoundingClientRect();return((coords.top>=0&&coords.left>=0&&coords.top)<=(window.innerHeight||document.documentElement.clientHeight)+parseInt(offset));};var _pollImages=function(){for(var i=store.length;i--;){var self=store[i];if(_inView(self)){self.src=self.getAttribute('data-echo');store.splice(i,1);}}};var _throttle=function(){clearTimeout(poll);poll=setTimeout(_pollImages,throttle);};var init=function(obj){var nodes=document.querySelectorAll('[data-echo]');var opts=obj||{};offset=opts.offset||0;throttle=opts.throttle||250;for(var i=0;i<nodes.length;i++){store.push(nodes[i]);}_throttle();if(document.addEventListener){window.addEventListener('scroll',_throttle,false);}else{window.attachEvent('onscroll',_throttle);}};return{init:init,render:_throttle};})(window,document);Echo.init({ offset: 0, throttle: 0 });



//发送验证码
function sendCode(){
    
	var myreg = /^1[3|4|5|6|7|8|9]\d{9}$/; 
	
	var telval = jQuery.trim($('#usertel').val())
	
	if(!myreg.test(telval)){
		layer.msg('请填写有效的手机号码',{time:1000}); 
		return;
	}else{
		var count = 50;
		var countdown = setInterval(CountDown,1000);
		function CountDown() {
			$(".Rebtn").attr("disabled", true);
			$(".Rebtn").css("background", '#ccc');
			$(".Rebtn").css("border", '1px solid #ccc');
			$(".Rebtn").text("短信已发送" + count);
			if (count == 0) {
				$(".Rebtn").val("再次发送").removeAttr("disabled");
				clearInterval(countdown);
			}
			count--;
		}
	}
	$.ajax({
        type : "post",
        dataType : "JSON",
        url : '__MODULE__/Register/sendMsgCode',
        data : {mobile:telval},
        success : function(str){
            if(str.status > 0){
                layer.msg(str.info,{time:1000});
            }else{
                layer.msg(str.info,{time:2000});
            }
        }
    });
}