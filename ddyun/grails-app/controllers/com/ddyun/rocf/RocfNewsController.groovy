package com.ddyun.rocf

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartFile
import com.ddyun.common.FileHandle
import com.ddyun.security.Member

@Transactional(readOnly = true)
class RocfNewsController {
	
	def springSecurityService

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RocfNews.list(params), model:[rocfNewsInstanceCount: RocfNews.count()]
    }

    def show(RocfNews rocfNewsInstance) {
        respond rocfNewsInstance
    }

    def create() {
        //respond new RocfNews(params)
		render view:"create",model:[]
    }

    @Transactional
    def save() {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		String title = request.getParameter("title")
		String content = request.getParameter("content")
		
		RocfNews rocfNewsInstance = new RocfNews()
		rocfNewsInstance.title = title
		rocfNewsInstance.content = content
		rocfNewsInstance.date = new Date()
		rocfNewsInstance.member = member
		
        if (rocfNewsInstance == null) {
            notFound()
            return
        }

        if (rocfNewsInstance.hasErrors()) {
            respond rocfNewsInstance.errors, view:'create'
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
			rocfNewsInstance.logo = newFilename
		}else{
			rocfNewsInstance.logo = "default.jpg"
		}

        rocfNewsInstance.save flush:true

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rocfNews.label', default: 'RocfNews'), rocfNewsInstance.id])
                redirect rocfNewsInstance
            }
            '*' { respond rocfNewsInstance, [status: CREATED] }
        }*/
		redirect (action: "list")
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
    def delete() {
		
		RocfNews rocfNewsInstance = RocfNews.findById(params.id)
		
        if (rocfNewsInstance == null) {
            notFound()
            return
        }

        rocfNewsInstance.delete flush:true
		
		redirect (action: "list")

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RocfNews.label', default: 'RocfNews'), rocfNewsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }*/
    }
	
	def list() {
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		//List<RocfNews> lists = RocfNews.list()
		//Set<RocfNews> lists = member.rocfnews
		
		Set<RocfNews> lists = null
		if(member.username.equals("admin")){
			lists = RocfNews.list()
		}else{
			lists = member.rocfnews
		}
		
		render view:"list",model:[lists:lists]
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
