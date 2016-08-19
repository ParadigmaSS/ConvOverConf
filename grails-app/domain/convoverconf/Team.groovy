package convoverconf

class Team {

	String name
	Integer number_of_members

	static belongsTo = [country: Country]
    static constraints = {
    }
}
