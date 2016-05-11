package com.ddyun.company

class CompanyCulture {
	
	String companyName;
	String companyTitle;
	String companyCultureContent;
	Date date;
	
    static constraints = {
		companyName nullable: true
		companyTitle nullable: true
		companyCultureContent nullable: true
		date nullable: true
    }
	
	String toString() {
		return this.companyName //+ " - " + this.spType + " - " + this.country
	}
}
