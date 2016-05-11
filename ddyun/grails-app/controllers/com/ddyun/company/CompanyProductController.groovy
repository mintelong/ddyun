package com.ddyun.company

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import com.ddyun.common.FileHandle

@Transactional(readOnly = true)
class CompanyProductController {

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyProduct.list(params), model:[companyProductInstanceCount: CompanyProduct.count()]
    }

    def show(CompanyProduct companyProductInstance) {
        respond companyProductInstance
    }

    def create() {
        //respond new CompanyProduct(params)
		render view:"create",model:[]
    }

    @Transactional
    def save() {
		
		String name = request.getParameter("name")
		String title = request.getParameter("title")
		String price = request.getParameter("price")
		
		CompanyProduct companyProductInstance = new  CompanyProduct()
		companyProductInstance.name = name
		companyProductInstance.title = title
		companyProductInstance.price = Double.valueOf(price)
		companyProductInstance.date = new Date()		
		
        if (companyProductInstance == null) {
            notFound()
            return
        }

        if (companyProductInstance.hasErrors()) {
            respond companyProductInstance.errors, view:'create'
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
			companyProductInstance.logo = newFilename
		}else{
			companyProductInstance.logo = "default.jpg"
		}

        companyProductInstance.save flush:true

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyProduct.label', default: 'CompanyProduct'), companyProductInstance.id])
                redirect companyProductInstance
            }
            '*' { respond companyProductInstance, [status: CREATED] }
        }*/
		redirect (action: "list")
    }

    def edit(CompanyProduct companyProductInstance) {
        respond companyProductInstance
    }

    @Transactional
    def update(CompanyProduct companyProductInstance) {
        if (companyProductInstance == null) {
            notFound()
            return
        }

        if (companyProductInstance.hasErrors()) {
            respond companyProductInstance.errors, view:'edit'
            return
        }

        companyProductInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompanyProduct.label', default: 'CompanyProduct'), companyProductInstance.id])
                redirect companyProductInstance
            }
            '*'{ respond companyProductInstance, [status: OK] }
        }
    }

    @Transactional
    def delete() {
		
		CompanyProduct companyProductInstance = CompanyProduct.findById(params.id)

        if (companyProductInstance == null) {
            notFound()
            return
        }

        companyProductInstance.delete flush:true
		
		redirect (action: "list")

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyProduct.label', default: 'CompanyProduct'), companyProductInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		
		List<CompanyProduct> lists = CompanyProduct.list()
		
		render view:"list",model:[lists:lists]
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companyProduct.label', default: 'CompanyProduct'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
