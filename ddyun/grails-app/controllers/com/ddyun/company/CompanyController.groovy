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
		def companyList = CompanyCulture.list(sort:"date", order:"desc")
		
		params.max = Math.min(params.max ? params.max.toInteger() : 15,  100)
			
		//params.max = 15;
		params.offset = params.offset ? params.offset.toInteger() : 0;
		
		//def ccc = companyList.findAll("companyName",[max:10,offset:params.offset.toInteger()]);
		def ccc = companyList.findAll();
		def total = ccc.count;
		
	
		render view:'law2',model:[companyList:companyList,total:total]
	}
	def law3() {
		def companyList = CompanyCulture.list(sort:"date", order:"desc")
		
		params.max = Math.min(params.max ? params.max.toInteger() : 15,  100)
			
		//params.max = 15;
	params.offset = params.offset ? params.offset.toInteger() : 0;
		
		//def ccc = companyList.findAll("companyName",[max:10,offset:params.offset.toInteger()]);
		def ccc = companyList.findAll();
		def total = ccc.count;
		
	
		render view:'law3',model:[companyList:companyList,total:total]
	}
	   
	
	
	def filtercomapny() {
		String type = params.type
		def companyList = CompanyCulture.findAllByType(type)
		
		def companyAll = CompanyCulture.findAll();
		
		for(CompanyCulture culture:companyAll){
			println culture.companyName
			println culture.type
			
		}
		params.max = Math.min(params.max ? params.max.toInteger() : 15,  100)
		//params.offset = params.offset ? params.offset.toInteger() : 0;
		params.offset =0;
		def offsetAfter = params.offset + 15
		//def ccc = companyList.findAll("companyName",[max:10,offset:params.offset.toInteger()]);
		def ccc = CompanyCulture.findAll();
		def total = ccc.count;
		
	
		
		render view:'law2',model:[companyList:companyList,total:total]
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
	
	def newscenter() {
		def companyList = CompanyNews.list(sort:"date", order:"desc")
		
		params.max = Math.min(params.max ? params.max.toInteger() : 15,  100)
			
		//params.max = 15;
		params.offset = params.offset ? params.offset.toInteger() : 0;
		
		def ccc = companyList.findAll();
		def total = ccc.count;
		
	
		render view:'newscenter',model:[companyList:companyList,total:total]
	}
	
	def filtercomapnynews() {
		String type = params.type
		def companyList = CompanyCulture.findAllByType(type)
		def cnlist = new ArrayList()
				
		for(CompanyCulture companyCulture:companyList){
			
			
			def companyNewsAll = CompanyNews.findAll();
		
			for(CompanyNews companyNews:companyNewsAll){
			if(companyNews.username == companyCulture.username){
				cnlist.add(companyNews)
				}
			}
		}
			
			
		
		params.max = Math.min(params.max ? params.max.toInteger() : 15,  100)
		//params.offset = params.offset ? params.offset.toInteger() : 0;
		params.offset =0;
		def offsetAfter = params.offset + 15
		
		def total = cnlist.count;
		
	
		
		render view:'newscenter',model:[companyList:cnlist,total:total]
	}
	
	def newscenter2() {
		def companyList = CompanyNews.list(sort:"date", order:"desc")
		
		params.max = Math.min(params.max ? params.max.toInteger() : 15,  100)
			
		//params.max = 15;
	params.offset = params.offset ? params.offset.toInteger() : 0;
		
		//def ccc = companyList.findAll("companyName",[max:10,offset:params.offset.toInteger()]);
		def ccc = companyList.findAll();
		def total = ccc.count;
		
	
		render view:'newscenter2',model:[companyList:companyList,total:total]
	
	}
}
