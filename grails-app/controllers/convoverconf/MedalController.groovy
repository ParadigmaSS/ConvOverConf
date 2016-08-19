package convoverconf

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MedalController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Medal.list(params), model:[medalCount: Medal.count()]
    }

    def show(Medal medal) {
        respond medal
    }

    def create() {
        respond new Medal(params)
    }

    @Transactional
    def save(Medal medal) {
        if (medal == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (medal.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond medal.errors, view:'create'
            return
        }

        medal.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'medal.label', default: 'Medal'), medal.id])
                redirect medal
            }
            '*' { respond medal, [status: CREATED] }
        }
    }

    def edit(Medal medal) {
        respond medal
    }

    @Transactional
    def update(Medal medal) {
        if (medal == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (medal.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond medal.errors, view:'edit'
            return
        }

        medal.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'medal.label', default: 'Medal'), medal.id])
                redirect medal
            }
            '*'{ respond medal, [status: OK] }
        }
    }

    @Transactional
    def delete(Medal medal) {

        if (medal == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        medal.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'medal.label', default: 'Medal'), medal.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'medal.label', default: 'Medal'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
