package com.ddyun.company

import static org.springframework.http.HttpStatus.*

import java.util.Date;
import org.springframework.web.multipart.MultipartFile
import com.ddyun.common.FileHandle
import com.ddyun.security.Member

import grails.transaction.Transactional

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCollection
import com.mongodb.Mongo

@Transactional(readOnly = false)
class CompanyCaseController {
	
	def springSecurityService

   // static allowedMethods = [save: "POST", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyCase.list(params), model:[companyCaseInstanceCount: CompanyCase.count()]
    }

    def show(CompanyCase companyCaseInstance) {
        respond companyCaseInstance
    }

    def create() {
        //respond new CompanyCase(params)
		render view:"create",model:[]
    }

    @Transactional
    def save() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		String name = request.getParameter("name")
		String describe = request.getParameter("describe")
		String url = request.getParameter("url")
		
        CompanyCase companyCaseInstance = new CompanyCase()
		companyCaseInstance.name = name
		companyCaseInstance.url = url
		companyCaseInstance.description = describe
		companyCaseInstance.date = new Date()
		companyCaseInstance.member = member
		
		MultipartFile logo = request.getFile("logo")
		
		def rootPath = request.getSession().getServletContext().getRealPath("/")
		
		if(logo&&!logo.isEmpty()) {
			def userDir = new File(rootPath + "ddyunimg" ,"/")
//			def userDir = new File(propertiesService.catchNewsImgUploadPath() ,"/")
			userDir.mkdirs()
			String filenameExt=FileHandle.getFilenameExtention(logo.getOriginalFilename())
			String newFilename=String.format("%tY%<tm%<td%<tH%<tM%<tS", new Date()) +"_" + (new Random().nextInt(1000))+"." + filenameExt
			logo.transferTo( new File(userDir, newFilename))
			companyCaseInstance.logo = newFilename
		}else{
			companyCaseInstance.logo = "default.jpg"
		}

        companyCaseInstance.save flush:true
		
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
		doc_info.put("tablename", name);
		doc_info.put("describe", describe);
		doc_info.put("type", "txt");
		doc_info.put("ispublish", true);
		doc_info.put("visitnum", 0);
		doc_info.put("isdelete", false);
		doc_info.put("fieldnum", 3);
		doc_info.put("dataType", 6);
		
		dataInfo.insert(doc_info);

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyCase.label', default: 'CompanyCase'), companyCaseInstance.id])
                redirect companyCaseInstance
            }
            '*' { respond companyCaseInstance, [status: CREATED] }
        }*/
		
		redirect (action: "list")
    }

    def edit(CompanyCase companyCaseInstance) {
        respond companyCaseInstance
    }

    @Transactional
    def update(CompanyCase companyCaseInstance) {
        if (companyCaseInstance == null) {
            notFound()
            return
        }

        if (companyCaseInstance.hasErrors()) {
            respond companyCaseInstance.errors, view:'edit'
            return
        }

        companyCaseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompanyCase.label', default: 'CompanyCase'), companyCaseInstance.id])
                redirect companyCaseInstance
            }
            '*'{ respond companyCaseInstance, [status: OK] }
        }
    }

    @Transactional
    def delete() {
		
		CompanyCase companyCaseInstance = CompanyCase.findById(params.id)
		
        if (companyCaseInstance == null) {
            notFound()
            return
        }

        companyCaseInstance.delete flush:true
		
		redirect (action: "list")

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyCase.label', default: 'CompanyCase'), companyCaseInstance.id])
                redirect action:"list", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		Set<CompanyCase> lists = null
		if(member.username.equals("admin")){
			lists = CompanyCase.list()
		}else{
			lists = member.companycases
		}
		
		render view:"list",model:[lists:lists]
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companyCase.label', default: 'CompanyCase'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	
}
