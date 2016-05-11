package com.ddyun.company



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional(readOnly = true)
class CompanyNewsController {

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyNews.list(params), model:[companyNewsInstanceCount: CompanyNews.count()]
    }

    def show(CompanyNews companyNewsInstance) {
        respond companyNewsInstance
    }

    def create() {
        //respond new CompanyNews(params)
		render view:"create",model:[]
    }

    @Transactional
    def save() {
		
		String title = request.getParameter("title")
		String content = request.getParameter("content")
		
		CompanyNews companyNewsInstance = new CompanyNews()
		companyNewsInstance.title = title
		companyNewsInstance.content = content
		companyNewsInstance.date = new Date()
			
        if (companyNewsInstance == null) {
            notFound()
            return
        }

        if (companyNewsInstance.hasErrors()) {
            respond companyNewsInstance.errors, view:'create'
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
			companyNewsInstance.logo = newFilename
		}else{
			companyNewsInstance.logo = "default.jpg"
		}

        companyNewsInstance.save flush:true

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyNews.label', default: 'CompanyNews'), companyNewsInstance.id])
                redirect companyNewsInstance
            }
            '*' { respond companyNewsInstance, [status: CREATED] }
        }*/
		redirect (action: "list")
    }

    def edit(CompanyNews companyNewsInstance) {
        respond companyNewsInstance
    }

    @Transactional
    def update(CompanyNews companyNewsInstance) {
        if (companyNewsInstance == null) {
            notFound()
            return
        }

        if (companyNewsInstance.hasErrors()) {
            respond companyNewsInstance.errors, view:'edit'
            return
        }

        companyNewsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompanyNews.label', default: 'CompanyNews'), companyNewsInstance.id])
                redirect companyNewsInstance
            }
            '*'{ respond companyNewsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete() {
		
		CompanyNews companyNewsInstance = CompanyNews.findById(params.id)

        if (companyNewsInstance == null) {
            notFound()
            return
        }

        companyNewsInstance.delete flush:true
		
		redirect (action: "list")

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyNews.label', default: 'CompanyNews'), companyNewsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		
		List<CompanyNews> lists = CompanyNews.list()
		
		render view:"list",model:[lists:lists]
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companyNews.label', default: 'CompanyNews'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
