package com.ddyun.company



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompanyEliteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyElite.list(params), model:[companyEliteInstanceCount: CompanyElite.count()]
    }

    def show(CompanyElite companyEliteInstance) {
        respond companyEliteInstance
    }

    def create() {
        respond new CompanyElite(params)
    }

    @Transactional
    def save(CompanyElite companyEliteInstance) {
        if (companyEliteInstance == null) {
            notFound()
            return
        }

        if (companyEliteInstance.hasErrors()) {
            respond companyEliteInstance.errors, view:'create'
            return
        }

        companyEliteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyElite.label', default: 'CompanyElite'), companyEliteInstance.id])
                redirect companyEliteInstance
            }
            '*' { respond companyEliteInstance, [status: CREATED] }
        }
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
    def delete(CompanyElite companyEliteInstance) {

        if (companyEliteInstance == null) {
            notFound()
            return
        }

        companyEliteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyElite.label', default: 'CompanyElite'), companyEliteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
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
