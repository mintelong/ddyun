package com.ddyun.company

class CompanyController {

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
		
		render view:'law2',model:[]
	}
	
	def pronav() {
		
		render view:'pronav',model:[]
	}
	
	def aboutus() {
		
		render view:'aboutus',model:[]
	}
	
	def companycase() {
		List<CompanyCase> lists = CompanyCase.list()
		
		render view:'companycase',model:[lists:lists]
		
	}
	
	def companyconnect() {
		
		render view:'companyconnect',model:[]
	}
	def companyelite() {
		
		render view:'companyelite',model:[]
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
		
		render view:'companyproduct',model:[]
	}
}
