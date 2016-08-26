package convoverconf

class Sport {

	String name
	String field

	static hasMany = [modalitys: Modality]
    
    static constraints = {
    }

    String toString() {
    	return name
    }
}
