package com.ddyun.company

import static org.springframework.http.HttpStatus.*

import java.util.Date;
import org.springframework.web.multipart.MultipartFile
import com.ddyun.common.FileHandle

import grails.transaction.Transactional

@Transactional(readOnly = false)
class CompanyCaseController {

    static allowedMethods = [save: "POST", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyCase.list(params), model:[companyCaseInstanceCount: CompanyCase.count()]
    }

    def show(CompanyCase companyCaseInstance) {
        respond companyCaseInstance
    }

    def create() {
        respond new CompanyCase(params)
    }

    @Transactional
    def save() {
        CompanyCase companyCaseInstance = new CompanyCase(
			name : params.name,
			date : new Date()
		)
		
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

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyCase.label', default: 'CompanyCase'), companyCaseInstance.id])
                redirect companyCaseInstance
            }
            '*' { respond companyCaseInstance, [status: CREATED] }
        }
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
    def delete(CompanyCase companyCaseInstance) {

        if (companyCaseInstance == null) {
            notFound()
            return
        }

        companyCaseInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyCase.label', default: 'CompanyCase'), companyCaseInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
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
