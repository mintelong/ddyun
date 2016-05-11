package com.ddyun.company



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompanyCultureController {

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
		
		String companyName = request.getParameter("companyName")
		String companyTitle = request.getParameter("companyTitle")
		String companyCultureContent = request.getParameter("companyCultureContent")
		
		CompanyCulture companyCultureInstance = new CompanyCulture()
		companyCultureInstance.companyName = companyName
		companyCultureInstance.companyTitle = companyTitle
		companyCultureInstance.companyCultureContent = companyCultureContent
		companyCultureInstance.date = new Date()
		
        if (companyCultureInstance == null) {
            notFound()
            return
        }

        if (companyCultureInstance.hasErrors()) {
            respond companyCultureInstance.errors, view:'create'
            return
        }

        companyCultureInstance.save flush:true

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
		
		List<CompanyCulture> lists = CompanyCulture.list()
		
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
