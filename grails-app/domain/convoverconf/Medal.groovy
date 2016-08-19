package convoverconf

class Medal {

	String type_of_medal	

	static belongsTo = [athlete: Athlete]
    
    static constraints = {
    }
}
