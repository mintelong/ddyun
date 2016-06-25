package com.ddyun.company

import static org.springframework.http.HttpStatus.*
import com.ddyun.security.Member
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import com.ddyun.common.FileHandle

import com.ddyun.dataCenter.*
import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCollection
import com.mongodb.Mongo

@Transactional(readOnly = true)
class CompanyCultureController {
	
	def springSecurityService

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyCulture.list(params), model:[companyCultureInstanceCount: CompanyCulture.count()]
    }

    def show(CompanyCulture companyCultureInstance) {
        respond companyCultureInstance
    }

    def create() {
        //respond new CompanyCulture(params)
		render view:"create",model:[]
    }

    @Transactional
    def save() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		String companyName = request.getParameter("companyName")
		String companyTitle = request.getParameter("companyTitle")
		String companyCultureContent = request.getParameter("companyCultureContent")
		String type = request.getParameter("type")
		
		CompanyCulture companyCultureInstance = new CompanyCulture()
		companyCultureInstance.companyName = companyName
		companyCultureInstance.companyTitle = companyTitle
		companyCultureInstance.companyCultureContent = companyCultureContent
		companyCultureInstance.date = new Date()
		companyCultureInstance.type = type
		companyCultureInstance.username = member.username
		companyCultureInstance.member = member
		
        MultipartFile logo = request.getFile("logo")
		
		def rootPath = request.getSession().getServletContext().getRealPath("/")
		
		if(logo&&!logo.isEmpty()) {
			def userDir = new File(rootPath + "ddyunimg" ,"/")
//			def userDir = new File(propertiesService.catchNewsImgUploadPath() ,"/")
			userDir.mkdirs()
			String filenameExt=FileHandle.getFilenameExtention(logo.getOriginalFilename())
			String newFilename=String.format("%tY%<tm%<td%<tH%<tM%<tS", new Date()) +"_" + (new Random().nextInt(1000))+"." + filenameExt
			logo.transferTo( new File(userDir, newFilename))
			companyCultureInstance.logo = newFilename
		}else{
			companyCultureInstance.logo = "default.jpg"
		}

        companyCultureInstance.save flush:true
		
		//数据同步到数据中心
		Mongo mongo = new Mongo("139.196.197.45", 27017);
		DB db = mongo.getDB("HSCSPDevDB");
		DBCollection dataType = db.getCollection("dataType")
		DBCollection dataInfo = db.getCollection("dataInfo")
		DBCollection dataDetail = db.getCollection("dataDetail")
		
		long count = dataInfo.getCount()
		println "count:"+count
		
		BasicDBObject doc_info = new BasicDBObject();
		doc_info.put("_id", count+10);
		doc_info.put("tablename", companyName);
		doc_info.put("describe", companyTitle);
		doc_info.put("type", "txt");
		doc_info.put("ispublish", true);
		doc_info.put("visitnum", 0);
		doc_info.put("isdelete", false);
		doc_info.put("fieldnum", 3);
		doc_info.put("dataType", 6);
		
		dataInfo.insert(doc_info);

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyCulture.label', default: 'CompanyCulture'), companyCultureInstance.id])
                redirect companyCultureInstance
            }
            '*' { respond companyCultureInstance, [status: CREATED] }
        }*/
		redirect (action: "list")
    }

    def edit(CompanyCulture companyCultureInstance) {
        respond companyCultureInstance
    }

    @Transactional
    def update(CompanyCulture companyCultureInstance) {
        if (companyCultureInstance == null) {
            notFound()
            return
        }

        if (companyCultureInstance.hasErrors()) {
            respond companyCultureInstance.errors, view:'edit'
            return
        }

        companyCultureInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompanyCulture.label', default: 'CompanyCulture'), companyCultureInstance.id])
                redirect companyCultureInstance
            }
            '*'{ respond companyCultureInstance, [status: OK] }
        }
    }

    @Transactional
    def delete() {
		
		CompanyCulture companyCultureInstance = CompanyCulture.findById(params.id)
		
        if (companyCultureInstance == null) {
            notFound()
            return
        }

        companyCultureInstance.delete flush:true
		
		redirect (action: "list")

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyCulture.label', default: 'CompanyCulture'), companyCultureInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		//List<CompanyCulture> lists = CompanyCulture.list()
		//Set<CompanyCulture> lists = member.companycultures
		
		Set<CompanyCulture> lists = null
		if(member.username.equals("admin")){
			lists = CompanyCulture.list()
		}else{
			lists = member.companycultures
		}
		
		render view:"list",model:[lists:lists]
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companyCulture.label', default: 'CompanyCulture'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
