package com.ddyun.company



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompanyContactController {

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyContact.list(params), model:[companyContactInstanceCount: CompanyContact.count()]
    }

    def show(CompanyContact companyContactInstance) {
        respond companyContactInstance
    }

    def create() {
        //respond new CompanyContact(params)
		render view:"create",model:[]
    }

    @Transactional
    def save() {
		
		String tel = request.getParameter("tel")
		String address = request.getParameter("address")
		String officer = request.getParameter("officer")
		String email = request.getParameter("email")
		
		CompanyContact companyContactInstance = new CompanyContact()
		companyContactInstance.tel = tel
		companyContactInstance.address = address
		companyContactInstance.officer = officer
		companyContactInstance.email = email
		companyContactInstance.date = new Date()
		
        if (companyContactInstance == null) {
            notFound()
            return
        }

        if (companyContactInstance.hasErrors()) {
            respond companyContactInstance.errors, view:'create'
            return
        }

        companyContactInstance.save flush:true

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyContact.label', default: 'CompanyContact'), companyContactInstance.id])
                redirect companyContactInstance
            }
            '*' { respond companyContactInstance, [status: CREATED] }
        }*/
		redirect (action: "list")
    }

    def edit(CompanyContact companyContactInstance) {
        respond companyContactInstance
    }

    @Transactional
    def update(CompanyContact companyContactInstance) {
        if (companyContactInstance == null) {
            notFound()
            return
        }

        if (companyContactInstance.hasErrors()) {
            respond companyContactInstance.errors, view:'edit'
            return
        }

        companyContactInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompanyContact.label', default: 'CompanyContact'), companyContactInstance.id])
                redirect companyContactInstance
            }
            '*'{ respond companyContactInstance, [status: OK] }
        }
    }

    @Transactional
    def delete() {
		
		CompanyContact companyContactInstance = CompanyContact.findById(params.id)
		
        if (companyContactInstance == null) {
            notFound()
            return
        }

        companyContactInstance.delete flush:true
		
		redirect (action: "list")
		
        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyContact.label', default: 'CompanyContact'), companyContactInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		
		List<CompanyContact> lists = CompanyContact.list()
		
		render view:"list",model:[lists:lists]
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'companyContact.label', default: 'CompanyContact'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
