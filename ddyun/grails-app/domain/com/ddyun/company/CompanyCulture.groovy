package com.ddyun.company

import com.ddyun.security.Member

class CompanyCulture {
	
	String companyName;
	String companyTitle;
	String companyCultureContent;
	Date date;
	String logo;
	
	static belongsTo = [member:Member]
	
    static constraints = {
		companyName nullable: true
		companyTitle nullable: true
		companyCultureContent nullable: true
		date nullable: true
		
		member nullable: true
    }
	
	String toString() {
		return this.companyName //+ " - " + this.spType + " - " + this.country
	}
}
