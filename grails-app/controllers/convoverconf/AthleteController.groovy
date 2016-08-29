package convoverconf

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AthleteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Athlete.list(params), model:[athleteCount: Athlete.count()]
    }

    def show(Athlete athlete) {
        respond athlete
    }

    def create() {
        respond new Athlete(params)
    }

    @Transactional
    def save(Athlete athlete) {
        if (athlete == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (athlete.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond athlete.errors, view:'create'
            return
        }

        athlete.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'athlete.label', default: 'Athlete'), athlete.id])
                redirect athlete
            }
            '*' { respond athlete, [status: CREATED] }
        }
    }

    def edit(Athlete athlete) {
        respond athlete
    }

    @Transactional
    def update(Athlete athlete) {
        if (athlete == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (athlete.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond athlete.errors, view:'edit'
            return
        }

        athlete.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'athlete.label', default: 'Athlete'), athlete.id])
                redirect athlete
            }
            '*'{ respond athlete, [status: OK] }
        }
    }

    @Transactional
    def delete(Athlete athlete) {

        if (athlete == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        athlete.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'athlete.label', default: 'Athlete'), athlete.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'athlete.label', default: 'Athlete'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def listing(){
        def athletes = Athlete.list()
        [athletes:athletes]
    }
}
