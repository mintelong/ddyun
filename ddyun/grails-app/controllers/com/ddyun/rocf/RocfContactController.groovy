package com.ddyun.rocf



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RocfContactController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RocfContact.list(params), model:[rocfContactInstanceCount: RocfContact.count()]
    }

    def show(RocfContact rocfContactInstance) {
        respond rocfContactInstance
    }

    def create() {
        respond new RocfContact(params)
    }

    @Transactional
    def save(RocfContact rocfContactInstance) {
        if (rocfContactInstance == null) {
            notFound()
            return
        }

        if (rocfContactInstance.hasErrors()) {
            respond rocfContactInstance.errors, view:'create'
            return
        }

        rocfContactInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rocfContact.label', default: 'RocfContact'), rocfContactInstance.id])
                redirect rocfContactInstance
            }
            '*' { respond rocfContactInstance, [status: CREATED] }
        }
    }

    def edit(RocfContact rocfContactInstance) {
        respond rocfContactInstance
    }

    @Transactional
    def update(RocfContact rocfContactInstance) {
        if (rocfContactInstance == null) {
            notFound()
            return
        }

        if (rocfContactInstance.hasErrors()) {
            respond rocfContactInstance.errors, view:'edit'
            return
        }

        rocfContactInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RocfContact.label', default: 'RocfContact'), rocfContactInstance.id])
                redirect rocfContactInstance
            }
            '*'{ respond rocfContactInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RocfContact rocfContactInstance) {

        if (rocfContactInstance == null) {
            notFound()
            return
        }

        rocfContactInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RocfContact.label', default: 'RocfContact'), rocfContactInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rocfContact.label', default: 'RocfContact'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
