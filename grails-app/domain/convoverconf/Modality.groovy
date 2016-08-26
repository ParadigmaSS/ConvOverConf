package convoverconf

class Modality {

	String name
	Sport sport
	
	static hasMany = [athletes: Athlete]
	static belongsTo = Athlete
    
    static constraints = {
    	athletes nullable: true
    }

    String toString() {
    	return name
    }
}
