package com.ddyun.rocf



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RocfWordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RocfWord.list(params), model:[rocfWordInstanceCount: RocfWord.count()]
    }

    def show(RocfWord rocfWordInstance) {
        respond rocfWordInstance
    }

    def create() {
        respond new RocfWord(params)
    }

    @Transactional
    def save(RocfWord rocfWordInstance) {
        if (rocfWordInstance == null) {
            notFound()
            return
        }

        if (rocfWordInstance.hasErrors()) {
            respond rocfWordInstance.errors, view:'create'
            return
        }

        rocfWordInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rocfWord.label', default: 'RocfWord'), rocfWordInstance.id])
                redirect rocfWordInstance
            }
            '*' { respond rocfWordInstance, [status: CREATED] }
        }
    }

    def edit(RocfWord rocfWordInstance) {
        respond rocfWordInstance
    }

    @Transactional
    def update(RocfWord rocfWordInstance) {
        if (rocfWordInstance == null) {
            notFound()
            return
        }

        if (rocfWordInstance.hasErrors()) {
            respond rocfWordInstance.errors, view:'edit'
            return
        }

        rocfWordInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RocfWord.label', default: 'RocfWord'), rocfWordInstance.id])
                redirect rocfWordInstance
            }
            '*'{ respond rocfWordInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RocfWord rocfWordInstance) {

        if (rocfWordInstance == null) {
            notFound()
            return
        }

        rocfWordInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RocfWord.label', default: 'RocfWord'), rocfWordInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rocfWord.label', default: 'RocfWord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
