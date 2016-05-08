package com.ddyun.user

import com.ddyun.security.Member

class UsercenterController {
	
	def springSecurityService

    def index() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		def roles = springSecurityService.getAuthentication()?.authorities
		
		Member member = (Member)user
		
		render view:'index', model:[user:member]
	}
	
	def publicmessage() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		def roles = springSecurityService.getAuthentication()?.authorities
		
		Member member = (Member)user
		
		render view:'publicmessage', model:[user:member]
	}
	
	def mymessage() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		def roles = springSecurityService.getAuthentication()?.authorities
		
		Member member = (Member)user
		
		render view:'mymessage', model:[user:member]
	}
	
}
