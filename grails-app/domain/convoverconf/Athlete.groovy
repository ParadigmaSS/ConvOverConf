package convoverconf

class Athlete {

	String name

	static hasMany = [medals: Medal, modalitys: Modality]
	static belongsTo = [country: Country, team: Team]
    
    static constraints = {
    	team nullable: true
    }
}
