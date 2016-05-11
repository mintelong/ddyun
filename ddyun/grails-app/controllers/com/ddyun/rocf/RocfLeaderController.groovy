package com.ddyun.rocf

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import com.ddyun.common.FileHandle
import com.ddyun.security.Member

@Transactional(readOnly = true)
class RocfLeaderController {

	def springSecurityService
	
    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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
    def save() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		String name = request.getParameter("name")
		String englishName = request.getParameter("englishName")
		String title = request.getParameter("title")
		String shortResume = request.getParameter("shortResume")
		String longResume = request.getParameter("longResume")
		
		RocfLeader rocfLeaderInstance = new RocfLeader()
		rocfLeaderInstance.name = name
		rocfLeaderInstance.englishName = englishName
		rocfLeaderInstance.title = title
		rocfLeaderInstance.shortResume = shortResume
		rocfLeaderInstance.longResume = longResume
		rocfLeaderInstance.date = new Date()
		rocfLeaderInstance.member = member
		
		
        if (rocfLeaderInstance == null) {
            notFound()
            return
        }

        if (rocfLeaderInstance.hasErrors()) {
            respond rocfLeaderInstance.errors, view:'create'
            return
        }
		
		MultipartFile logo = request.getFile("logo")
		
		def rootPath = request.getSession().getServletContext().getRealPath("/")
		
		if(logo&&!logo.isEmpty()) {
			def userDir = new File(rootPath + "ddyunimg" ,"/")
//			def userDir = new File(propertiesService.catchNewsImgUploadPath() ,"/")
			userDir.mkdirs()
			String filenameExt=FileHandle.getFilenameExtention(logo.getOriginalFilename())
			String newFilename=String.format("%tY%<tm%<td%<tH%<tM%<tS", new Date()) +"_" + (new Random().nextInt(1000))+"." + filenameExt
			logo.transferTo( new File(userDir, newFilename))
			rocfLeaderInstance.logo = newFilename
		}else{
			rocfLeaderInstance.logo = "default.jpg"
		}

        rocfLeaderInstance.save flush:true

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rocfLeader.label', default: 'RocfLeader'), rocfLeaderInstance.id])
                redirect rocfLeaderInstance
            }
            '*' { respond rocfLeaderInstance, [status: CREATED] }
        }*/
		redirect (action: "list")
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
    def delete() {
		
		RocfLeader rocfLeaderInstance = RocfLeader.findById(params.id)

        if (rocfLeaderInstance == null) {
            notFound()
            return
        }

        rocfLeaderInstance.delete flush:true
		
		redirect (action: "list")

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RocfLeader.label', default: 'RocfLeader'), rocfLeaderInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		
		List<RocfLeader> lists = RocfLeader.list()
		
		render view:"list",model:[lists:lists]
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
