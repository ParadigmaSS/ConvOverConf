package convoverconf

class Athlete {

	String name

	static belongsTo = [country: Country]
    static constraints = {
    }
}
