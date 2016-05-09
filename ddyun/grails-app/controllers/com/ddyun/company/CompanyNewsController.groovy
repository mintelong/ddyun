package com.ddyun.company



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompanyNewsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompanyNews.list(params), model:[companyNewsInstanceCount: CompanyNews.count()]
    }

    def show(CompanyNews companyNewsInstance) {
        respond companyNewsInstance
    }

    def create() {
        respond new CompanyNews(params)
    }

    @Transactional
    def save(CompanyNews companyNewsInstance) {
        if (companyNewsInstance == null) {
            notFound()
            return
        }

        if (companyNewsInstance.hasErrors()) {
            respond companyNewsInstance.errors, view:'create'
            return
        }

        companyNewsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'companyNews.label', default: 'CompanyNews'), companyNewsInstance.id])
                redirect companyNewsInstance
            }
            '*' { respond companyNewsInstance, [status: CREATED] }
        }
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
    def delete(CompanyNews companyNewsInstance) {

        if (companyNewsInstance == null) {
            notFound()
            return
        }

        companyNewsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompanyNews.label', default: 'CompanyNews'), companyNewsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
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
