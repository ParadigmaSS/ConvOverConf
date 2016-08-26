package convoverconf

class Medal {

	String type_of_medal
	String rank_of_medal	

	static belongsTo = [athlete: Athlete]
    
    static constraints = {
    }

    String toString() {
    	return rank_of_medal
    }
}
