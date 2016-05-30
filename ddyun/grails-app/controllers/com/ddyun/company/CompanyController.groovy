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
		int nc = CompanyNews.count()
		render view:'aboutus',model:[cc:cc,user:user,nc:nc]
	}
	
	def companycase2() {
		def uid = params.uid
		Member user = Member.get(uid)
		def clist = user.companycases
		int nc = CompanyNews.count()
		render view:'companycase',model:[clist:clist,user:user,nc:nc]
		
	}
	
	def companycase() {
		List<CompanyCase> lists = CompanyCase.list()
		int nc = CompanyNews.count()
		render view:'companycase',model:[lists:lists,nc:nc]
		
	}
	
	def companyconnect() {
		def uid = params.uid
		Member user = Member.get(uid)
		CompanyContact cc = user.companycontacts.getAt(0)
		int nc = CompanyNews.count()
		render view:'companyconnect',model:[cc:cc,user:user,nc:nc]
	}
	def companyelite() {
		def uid = params.uid
		Member user = Member.get(uid)
		def elist = user.companyelites
		int nc = CompanyNews.count()
		render view:'companyelite',model:[elist:elist,user:user,nc:nc]
	}
	def companynews() {
		def uid = params.uid
		Member user = Member.get(uid)
		def nlist = CompanyNews.list()
		int nc = CompanyNews.count()
		render view:'companynews',model:[nlist:nlist,user:user,nc:nc]
	}
	def companynewsdt() {
		
		render view:'companynewsdt',model:[]
	}
	def companywork() {
		def uid = params.uid
		Member user = Member.get(uid)
		int nc = CompanyNews.count()
		render view:'companywork',model:[user:user,nc:nc]
	}
	
	def companyproduct() {
		def uid = params.uid
		Member user = Member.get(uid)
		def plist = user.companyproducts
		int nc = CompanyNews.count()
		render view:'companyproduct',model:[plist:plist,user:user,nc:nc]
	}
	
	def questions() {
		
		render view:'questions',model:[]
	}
}
