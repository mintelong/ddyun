package com.ddyun.index
import com.ddyun.company.CompanyNews
import com.ddyun.dataCenter.Words

class IndexController {

    def index() {
		def newsList = CompanyNews.list(sort:"date", order:"desc")
		render view:"index",model:[newsList:newsList]
	}
	
	//企业
	//company_culture
	def aboutus() {}
		
	def companyelite() {}
	
	def companycase() {}
	
	def companyconnect() {}
	
	def companynews() {}
	
	def companynewsdt() {}
	
	def companyproduct() {}

	def companywork() {}
	
	//侨联
	def rocfculture() {}
	
	def rockleader() {}
	
	def rockrules() {}
	
	def rockteam() {}
	
	def rockword() {}
	//
	
	def uscenter() {
		def wlist = Words.list()
		render view:"uscenter",model:[wlist:wlist]
	}
	
	def serviceagreement(){}
	
	def privacy(){}
	
}
