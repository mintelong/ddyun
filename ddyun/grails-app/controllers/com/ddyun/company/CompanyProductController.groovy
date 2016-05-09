package com.ddyun.company



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompanyProductController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyProduct.list(params), model:[companyProductInstanceCount: CompanyProduct.count()]
    }

    def show(CompanyProduct companyProductInstance) {
        respond companyProductInstance
    }

    def create() {
        respond new CompanyProduct(params)
    }

    @Transactional
    def save(CompanyProduct companyProductInstance) {
        if (companyProductInstance == null) {
            notFound()
            return
        }

        if (companyProductInstance.hasErrors()) {
            respond companyProductInstance.errors, view:'create'
            return
        }

        companyProductInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyProduct.label', default: 'CompanyProduct'), companyProductInstance.id])
                redirect companyProductInstance
            }
            '*' { respond companyProductInstance, [status: CREATED] }
        }
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
    def delete(CompanyProduct companyProductInstance) {

        if (companyProductInstance == null) {
            notFound()
            return
        }

        companyProductInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyProduct.label', default: 'CompanyProduct'), companyProductInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
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
