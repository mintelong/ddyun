package com.ddyun.rocf



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RocfNewsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RocfNews.list(params), model:[rocfNewsInstanceCount: RocfNews.count()]
    }

    def show(RocfNews rocfNewsInstance) {
        respond rocfNewsInstance
    }

    def create() {
        respond new RocfNews(params)
    }

    @Transactional
    def save(RocfNews rocfNewsInstance) {
        if (rocfNewsInstance == null) {
            notFound()
            return
        }

        if (rocfNewsInstance.hasErrors()) {
            respond rocfNewsInstance.errors, view:'create'
            return
        }

        rocfNewsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rocfNews.label', default: 'RocfNews'), rocfNewsInstance.id])
                redirect rocfNewsInstance
            }
            '*' { respond rocfNewsInstance, [status: CREATED] }
        }
    }

    def edit(RocfNews rocfNewsInstance) {
        respond rocfNewsInstance
    }

    @Transactional
    def update(RocfNews rocfNewsInstance) {
        if (rocfNewsInstance == null) {
            notFound()
            return
        }

        if (rocfNewsInstance.hasErrors()) {
            respond rocfNewsInstance.errors, view:'edit'
            return
        }

        rocfNewsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RocfNews.label', default: 'RocfNews'), rocfNewsInstance.id])
                redirect rocfNewsInstance
            }
            '*'{ respond rocfNewsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RocfNews rocfNewsInstance) {

        if (rocfNewsInstance == null) {
            notFound()
            return
        }

        rocfNewsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RocfNews.label', default: 'RocfNews'), rocfNewsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rocfNews.label', default: 'RocfNews'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
