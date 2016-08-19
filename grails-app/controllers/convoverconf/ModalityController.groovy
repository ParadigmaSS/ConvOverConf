package convoverconf

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ModalityController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Modality.list(params), model:[modalityCount: Modality.count()]
    }

    def show(Modality modality) {
        respond modality
    }

    def create() {
        respond new Modality(params)
    }

    @Transactional
    def save(Modality modality) {
        if (modality == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (modality.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond modality.errors, view:'create'
            return
        }

        modality.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'modality.label', default: 'Modality'), modality.id])
                redirect modality
            }
            '*' { respond modality, [status: CREATED] }
        }
    }

    def edit(Modality modality) {
        respond modality
    }

    @Transactional
    def update(Modality modality) {
        if (modality == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (modality.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond modality.errors, view:'edit'
            return
        }

        modality.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'modality.label', default: 'Modality'), modality.id])
                redirect modality
            }
            '*'{ respond modality, [status: OK] }
        }
    }

    @Transactional
    def delete(Modality modality) {

        if (modality == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        modality.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'modality.label', default: 'Modality'), modality.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'modality.label', default: 'Modality'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
