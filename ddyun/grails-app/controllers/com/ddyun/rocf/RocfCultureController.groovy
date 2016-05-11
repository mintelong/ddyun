package com.ddyun.rocf



import static org.springframework.http.HttpStatus.*
import com.ddyun.security.Member
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RocfCultureController {
	
	def springSecurityService

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RocfCulture.list(params), model:[rocfCultureInstanceCount: RocfCulture.count()]
    }

    def show(RocfCulture rocfCultureInstance) {
        respond rocfCultureInstance
    }

    def create() {
        respond new RocfCulture(params)
    }

    @Transactional
    def save() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
				
		String title = request.getParameter("title")
		String content = request.getParameter("content")
		
		RocfCulture rocfCultureInstance = new RocfCulture()
		rocfCultureInstance.title = title
		rocfCultureInstance.content = content
		rocfCultureInstance.date = new Date()
		rocfCultureInstance.member = member
		
        if (rocfCultureInstance == null) {
            notFound()
            return
        }

        if (rocfCultureInstance.hasErrors()) {
            respond rocfCultureInstance.errors, view:'create'
            return
        }

        rocfCultureInstance.save flush:true

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rocfCulture.label', default: 'RocfCulture'), rocfCultureInstance.id])
                redirect rocfCultureInstance
            }
            '*' { respond rocfCultureInstance, [status: CREATED] }
        }*/
		redirect (action: "list")
    }

    def edit(RocfCulture rocfCultureInstance) {
        respond rocfCultureInstance
    }

    @Transactional
    def update(RocfCulture rocfCultureInstance) {
        if (rocfCultureInstance == null) {
            notFound()
            return
        }

        if (rocfCultureInstance.hasErrors()) {
            respond rocfCultureInstance.errors, view:'edit'
            return
        }

        rocfCultureInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RocfCulture.label', default: 'RocfCulture'), rocfCultureInstance.id])
                redirect rocfCultureInstance
            }
            '*'{ respond rocfCultureInstance, [status: OK] }
        }
    }

    @Transactional
    def delete() {
		
		RocfCulture rocfCultureInstance = RocfCulture.findById(params.id)
		
        if (rocfCultureInstance == null) {
            notFound()
            return
        }

        rocfCultureInstance.delete flush:true
		
		redirect (action: "list")

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RocfCulture.label', default: 'RocfCulture'), rocfCultureInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		//List<RocfCulture> lists = RocfCulture.list()
		List<RocfCulture> lists = member.rocfcultures
		
		render view:"list",model:[lists:lists]
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rocfCulture.label', default: 'RocfCulture'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
