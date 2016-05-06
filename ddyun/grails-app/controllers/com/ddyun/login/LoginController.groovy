package com.ddyun.login

import com.ddyun.security.Member
import grails.converters.JSON

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityUtils;

import java.text.SimpleDateFormat
import java.util.Date;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.web.WebAttributes;

import javax.servlet.http.HttpServletResponse

class LoginController {
	
	/**
	 * Dependency injection for the authenticationTrustResolver.
	 */
	def authenticationTrustResolver

	/**
	 * Dependency injection for the springSecurityService.
	 */
	def springSecurityService

    def index() {		
		if(params.login){
			if(springSecurityService.isLoggedIn()){
				request.setAttribute("login", false)
			}else{
				request.setAttribute("login", true)
			}
		}
		render view:'index',model:[]
	}
	
	def login(){
		
		def config = SpringSecurityUtils.securityConfig
		
		if (springSecurityService.isLoggedIn()) {
			redirect uri: config.successHandler.defaultTargetUrl
			return
		}

		String view = 'login'
		String postUrl = "${request.contextPath}${config.apf.filterProcessesUrl}"
		render view: view, model: [postUrl: postUrl,
								   rememberMeParameter: config.rememberMe.parameter]
	}
	
	def register(){
		render view:'register',model:[]
	}
	
	def save(){
		def username = params.username
		def password = params.password
		def birthday = params.birthday
		def mail = params.mail
		
		if(username && password){
			Member member = new Member(username , password)
			member.save(flush : true)
		}
		redirect(controller:"index" , action : "index")
	}
	
	def checkUsername(){
		Map map = [:]
		def username = params.username
		if(username){
			def user = Member.findByUsername(username)
			if(!user){
				map.put("result" , true)
				map.put("info" , "用户不存在")
				render map as JSON
				return
			}
			map.put("result" , false)
			map.put("info" , "用户已存在")
			render map as JSON
			return
		}
		map.put("result" , false)
		map.put("info" , "参数错误")
		render map as JSON
		return
	}
	
	def isLoggedIn(){
		if(springSecurityService.isLoggedIn()){
			render true
			return
		}
		render false
	}
	
	def logout(){
		
	}
}
