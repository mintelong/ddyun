package com.ddyun.rocf



import static org.springframework.http.HttpStatus.*
import com.ddyun.security.Member
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RocfContactController {
	
	def springSecurityService

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RocfContact.list(params), model:[rocfContactInstanceCount: RocfContact.count()]
    }

    def show(RocfContact rocfContactInstance) {
        respond rocfContactInstance
    }

    def create() {
        //respond new RocfContact(params)
		render view:"create",model:[]
    }

    @Transactional
    def save() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		String tel = request.getParameter("tel")
		String address = request.getParameter("address")
		String officer = request.getParameter("officer")
		String email = request.getParameter("email")
		
		RocfContact rocfContactInstance = new RocfContact()
		rocfContactInstance.tel = tel
		rocfContactInstance.address = address
		rocfContactInstance.officer = officer
		rocfContactInstance.email = email
		rocfContactInstance.date = new Date()
		rocfContactInstance.member = member
		
        if (rocfContactInstance == null) {
            notFound()
            return
        }

        if (rocfContactInstance.hasErrors()) {
            respond rocfContactInstance.errors, view:'create'
            return
        }

        rocfContactInstance.save flush:true

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rocfContact.label', default: 'RocfContact'), rocfContactInstance.id])
                redirect rocfContactInstance
            }
            '*' { respond rocfContactInstance, [status: CREATED] }
        }*/
		redirect (action: "list")
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
    def delete() {
		
		RocfContact rocfContactInstance = RocfContact.findById(params.id)
		
        if (rocfContactInstance == null) {
            notFound()
            return
        }

        rocfContactInstance.delete flush:true
		
		redirect (action: "list")

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RocfContact.label', default: 'RocfContact'), rocfContactInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		//List<RocfContact> lists = RocfContact.list()
		List<RocfContact> lists = member.rocfcontacts
		
		render view:"list",model:[lists:lists]
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
