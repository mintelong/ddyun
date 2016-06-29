package com.ddyun.dataCenter



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WordsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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
