package com.ddyun.rocf



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RocfLeaderController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RocfLeader.list(params), model:[rocfLeaderInstanceCount: RocfLeader.count()]
    }

    def show(RocfLeader rocfLeaderInstance) {
        respond rocfLeaderInstance
    }

    def create() {
        respond new RocfLeader(params)
    }

    @Transactional
    def save(RocfLeader rocfLeaderInstance) {
        if (rocfLeaderInstance == null) {
            notFound()
            return
        }

        if (rocfLeaderInstance.hasErrors()) {
            respond rocfLeaderInstance.errors, view:'create'
            return
        }

        rocfLeaderInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rocfLeader.label', default: 'RocfLeader'), rocfLeaderInstance.id])
                redirect rocfLeaderInstance
            }
            '*' { respond rocfLeaderInstance, [status: CREATED] }
        }
    }

    def edit(RocfLeader rocfLeaderInstance) {
        respond rocfLeaderInstance
    }

    @Transactional
    def update(RocfLeader rocfLeaderInstance) {
        if (rocfLeaderInstance == null) {
            notFound()
            return
        }

        if (rocfLeaderInstance.hasErrors()) {
            respond rocfLeaderInstance.errors, view:'edit'
            return
        }

        rocfLeaderInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RocfLeader.label', default: 'RocfLeader'), rocfLeaderInstance.id])
                redirect rocfLeaderInstance
            }
            '*'{ respond rocfLeaderInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RocfLeader rocfLeaderInstance) {

        if (rocfLeaderInstance == null) {
            notFound()
            return
        }

        rocfLeaderInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RocfLeader.label', default: 'RocfLeader'), rocfLeaderInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rocfLeader.label', default: 'RocfLeader'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
