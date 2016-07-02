package com.ddyun.dataCenter



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import com.ddyun.security.Member

@Transactional(readOnly = true)
class WordsController {
	
	def springSecurityService

    static allowedMethods = [add: "POST", save: "POST", replysave: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Words.list(params), model:[wordsInstanceCount: Words.count()]
    }

    def show(Words wordsInstance) {
        respond wordsInstance
    }

    def create() {
        respond new Words(params)
    }
	
	def ask() {
		respond new Words(params)
	}
	
	@Transactional
	def add(Words wordsInstance) {
		
		//获取用户基本信息
		def user = springSecurityService.getCurrentUser()
		Member member = (Member)user
		
		wordsInstance.member = member

		wordsInstance.save flush:true

		redirect(controller: "index", action: "uscenter")
	}
	
	@Transactional
	def reply(){
		def wid = request.getParameter("wid")
		Words ws = Words.get(wid)
		render view:"reply",model:[ws:ws]
	}
	
	@Transactional
	def replysave() {
		def wid = params.id
		def reply = params.reply
		println(wid + "-------------------")
		println(reply + "-------------------")
		Words ws = Words.get(wid)
		ws.setReply(reply)
		
		ws.save flush:true

		redirect(controller: "index", action: "uscenter")
	}

    @Transactional
    def save(Words wordsInstance) {
        if (wordsInstance == null) {
            notFound()
            return
        }

        if (wordsInstance.hasErrors()) {
            respond wordsInstance.errors, view:'create'
            return
        }

        wordsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'words.label', default: 'Words'), wordsInstance.id])
                redirect wordsInstance
            }
            '*' { respond wordsInstance, [status: CREATED] }
        }
    }

    def edit(Words wordsInstance) {
        respond wordsInstance
    }

    @Transactional
    def update(Words wordsInstance) {
        if (wordsInstance == null) {
            notFound()
            return
        }

        if (wordsInstance.hasErrors()) {
            respond wordsInstance.errors, view:'edit'
            return
        }

        wordsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Words.label', default: 'Words'), wordsInstance.id])
                redirect wordsInstance
            }
            '*'{ respond wordsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Words wordsInstance) {

        if (wordsInstance == null) {
            notFound()
            return
        }

        wordsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Words.label', default: 'Words'), wordsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'words.label', default: 'Words'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
