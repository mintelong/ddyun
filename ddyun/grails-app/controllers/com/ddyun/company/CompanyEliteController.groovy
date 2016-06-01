package com.ddyun.company

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import com.ddyun.common.FileHandle
import com.ddyun.security.Member

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCollection
import com.mongodb.Mongo

@Transactional(readOnly = true)
class CompanyEliteController {
	
	def springSecurityService

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyElite.list(params), model:[companyEliteInstanceCount: CompanyElite.count()]
    }

    def show(CompanyElite companyEliteInstance) {
        respond companyEliteInstance
    }

    def create() {
        //respond new CompanyElite(params)
		render view:"create",model:[]
    }

    @Transactional
    def save() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		String name = request.getParameter("name")
		String englishName = request.getParameter("englishName")
		String title = request.getParameter("title")
		String shortResume = request.getParameter("shortResume")
		String longResume = request.getParameter("longResume")
		
		CompanyElite companyEliteInstance = new CompanyElite()
		companyEliteInstance.name = name
		companyEliteInstance.englishName = englishName
		companyEliteInstance.title = title
		companyEliteInstance.shortResume = shortResume
		companyEliteInstance.longResume = longResume
		companyEliteInstance.date = new Date()
		companyEliteInstance.member = member
		
        if (companyEliteInstance == null) {
            notFound()
            return
        }

        if (companyEliteInstance.hasErrors()) {
            respond companyEliteInstance.errors, view:'create'
            return
        }
		
		MultipartFile logo = request.getFile("logo")
		
		def rootPath = request.getSession().getServletContext().getRealPath("/")
		
		if(logo&&!logo.isEmpty()) {
			def userDir = new File(rootPath + "ddyunimg" ,"/")
//			def userDir = new File(propertiesService.catchNewsImgUploadPath() ,"/")
			userDir.mkdirs()
			String filenameExt=FileHandle.getFilenameExtention(logo.getOriginalFilename())
			String newFilename=String.format("%tY%<tm%<td%<tH%<tM%<tS", new Date()) +"_" + (new Random().nextInt(1000))+"." + filenameExt
			logo.transferTo( new File(userDir, newFilename))
			companyEliteInstance.logo = newFilename
		}else{
			companyEliteInstance.logo = "default.jpg"
		}

        companyEliteInstance.save flush:true
		
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
		doc_info.put("describe", title);
		doc_info.put("type", "txt");
		doc_info.put("ispublish", true);
		doc_info.put("visitnum", 0);
		doc_info.put("isdelete", false);
		doc_info.put("fieldnum", 3);
		doc_info.put("dataType", 6);
		
		dataInfo.insert(doc_info);

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyElite.label', default: 'CompanyElite'), companyEliteInstance.id])
                redirect companyEliteInstance
            }
            '*' { respond companyEliteInstance, [status: CREATED] }
        }*/
		redirect (action: "list")
    }

    def edit(CompanyElite companyEliteInstance) {
        respond companyEliteInstance
    }

    @Transactional
    def update(CompanyElite companyEliteInstance) {
        if (companyEliteInstance == null) {
            notFound()
            return
        }

        if (companyEliteInstance.hasErrors()) {
            respond companyEliteInstance.errors, view:'edit'
            return
        }

        companyEliteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompanyElite.label', default: 'CompanyElite'), companyEliteInstance.id])
                redirect companyEliteInstance
            }
            '*'{ respond companyEliteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete() {
		
		CompanyElite companyEliteInstance = CompanyElite.findById(params.id)
		
        if (companyEliteInstance == null) {
            notFound()
            return
        }

        companyEliteInstance.delete flush:true
		
		redirect (action: "list")
		
        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyElite.label', default: 'CompanyElite'), companyEliteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		//List<CompanyElite> lists = CompanyElite.list()
		//Set<CompanyElite> lists = member.companyelites
		
		Set<CompanyElite> lists = null
		if(member.username.equals("admin")){
			lists = CompanyElite.list()
		}else{
			lists = member.companyelites
		}
		
		render view:"list",model:[lists:lists]
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companyElite.label', default: 'CompanyElite'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
