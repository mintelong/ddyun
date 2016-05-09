package com.ddyun.company



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompanyContactController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyContact.list(params), model:[companyContactInstanceCount: CompanyContact.count()]
    }

    def show(CompanyContact companyContactInstance) {
        respond companyContactInstance
    }

    def create() {
        respond new CompanyContact(params)
    }

    @Transactional
    def save(CompanyContact companyContactInstance) {
        if (companyContactInstance == null) {
            notFound()
            return
        }

        if (companyContactInstance.hasErrors()) {
            respond companyContactInstance.errors, view:'create'
            return
        }

        companyContactInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyContact.label', default: 'CompanyContact'), companyContactInstance.id])
                redirect companyContactInstance
            }
            '*' { respond companyContactInstance, [status: CREATED] }
        }
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
    def delete(CompanyContact companyContactInstance) {

        if (companyContactInstance == null) {
            notFound()
            return
        }

        companyContactInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyContact.label', default: 'CompanyContact'), companyContactInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
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
