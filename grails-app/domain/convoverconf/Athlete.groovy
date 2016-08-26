package convoverconf

class Athlete {

	String name
	String genre
	Integer age
	double weight

	static hasMany = [medals: Medal, modalitys: Modality]
	static belongsTo = [country: Country, team: Team]
    
    static constraints = {
    	team nullable: true
    }

    String toString() {
    	return name
    }
}
