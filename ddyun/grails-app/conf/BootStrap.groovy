import com.ddyun.security.Authority
import com.ddyun.security.Member
import com.ddyun.security.MemberAuthority
import com.ddyun.security.RequestMap

class BootStrap {
	

    def init = { servletContext ->
		
		println "bootstrap init starting......"
		
		
		/*def requestMap = RequestMap.findAll()
		for(def req : requestMap){
			req.delete(flush:true)
		}
		
		//基础文件
		RequestMap.create('/js/**','permitAll',true)
		RequestMap.create('/css/**','permitAll',true)
		RequestMap.create('/images/**','permitAll',true)
		RequestMap.create('/img/**','permitAll',true)
		RequestMap.create('/error','permitAll',true)
		RequestMap.create('/assets/**','permitAll',true)
		RequestMap.create('/fonts/**','permitAll',true)
		//整体拦截
		RequestMap.create('/**','permitAll',true)
		//首页权限放开
		RequestMap.create('/','permitAll',true)
		RequestMap.create('/index/index','permitAll',true)
		//登陆模块权限放开
		RequestMap.create('/login/**','permitAll',true)
		RequestMap.create('/logout/**','permitAll',true)
		
		 
		def authorities = Authority.findAll()
		for(def auth : authorities){
			auth.delete(flush:true)
		}
		
		//权限设置
		if(!Authority.findByAuthority("ROLE_ADMIN")){
			def authority = new Authority("ROLE_ADMIN")
			authority.save(flush : true)
		}
		
		if(!Member.findByUsername("admin")){
			 def adminInstance = new Member()
			 adminInstance.username = "admin"
			 adminInstance.password = "admin"
			 adminInstance.save flush:true
			 def auth = Authority.findByAuthority("ROLE_ADMIN")
			 MemberAuthority.create(adminInstance, auth)
		}*/
		
		println "bootstrap init ending"
		
    }
    def destroy = {
    }
}
