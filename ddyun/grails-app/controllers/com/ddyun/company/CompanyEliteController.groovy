package com.ddyun.company

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import com.ddyun.common.FileHandle
import com.ddyun.security.Member

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
		List<CompanyElite> lists = member.companyelites
		
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
