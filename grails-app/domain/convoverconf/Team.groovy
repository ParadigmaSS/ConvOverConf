package convoverconf

class Team {

	String name
	Integer number_of_members

	static hasMany = [athletes: Athlete]
	static belongsTo = [country: Country]
   
    static constraints = {
    }

    String toString() {
    	return name
    }
}
