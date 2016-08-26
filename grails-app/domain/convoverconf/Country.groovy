package convoverconf

class Country {

	String name
	String initials

	static hasMany = [athletes: Athlete, teams: Team]
    
    static constraints = {
    }

    String toString() {
    	return name
    }
}