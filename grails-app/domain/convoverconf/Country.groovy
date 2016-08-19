package convoverconf

class Country {

	String name

	static hasMany = [athletes: Athlete, teams: Team]
    static constraints = {
    }
}
