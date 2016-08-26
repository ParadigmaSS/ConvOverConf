package convoverconf

class Sport {

	String name

	static hasMany = [modalitys: Modality]
    
    static constraints = {
    }
}
