package com.ddyun.company

import com.ddyun.security.Member

class CompanyController {
	
	def springSecurityService

    def product() {
		
		render view:'product',model:[]
	}
	
	def pcase() {
		
		render view:'pcase',model:[]
	}
	
	def connect() {
		
		render view:'connect',model:[]
	}
	
	def culture() {
		
		render view:'culture',model:[]
	}
	
	def elite() {
		
		render view:'elite',model:[]
	}
	
	def news() {
		
		render view:'news',model:[]
	}
	
	def work() {
		
		render view:'work',model:[]
	}
	
	def law() {
		
		render view:'law',model:[]
	}
	
	def law2() {
		def companyList = CompanyCulture.list()
		render view:'law2',model:[companyList:companyList]
	}
	
	def pronav() {
		
		render view:'pronav',model:[]
	}
	
	def aboutus() {
		def uid = params.uid
		Member user = Member.get(uid)
		CompanyCulture cc = user.companycultures.getAt(0)
		render view:'aboutus',model:[cc:cc,user:user]
	}
	
	def companycase2() {
		def uid = params.uid
		Member user = Member.get(uid)
		def clist = user.companycases
		render view:'companycase',model:[clist:clist,user:user]
		
	}
	
	def companycase() {
		List<CompanyCase> lists = CompanyCase.list()
		
		render view:'companycase',model:[lists:lists]
		
	}
	
	def companyconnect() {
		def uid = params.uid
		Member user = Member.get(uid)
		CompanyContact cc = user.companycontacts.getAt(0)
		render view:'companyconnect',model:[cc:cc,user:user]
	}
	def companyelite() {
		def uid = params.uid
		Member user = Member.get(uid)
		def elist = user.companyelites
		render view:'companyelite',model:[elist:elist,user:user]
	}
	def companynews() {
		
		render view:'companynews',model:[]
	}
	def companynewsdt() {
		
		render view:'companynewsdt',model:[]
	}
	def companywork() {
		
		render view:'companywork',model:[]
	}
	
	def companyproduct() {
		def uid = params.uid
		Member user = Member.get(uid)
		def plist = user.companyproducts
		render view:'companyproduct',model:[plist:plist,user:user]
	}
}
