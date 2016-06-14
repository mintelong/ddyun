package com.ddyun.company

import com.ddyun.security.Member

class CompanyCulture {
	
	String companyName;
	String companyTitle;
	String companyCultureContent;
	Date date;
	String logo;
	
	String type;//企业类别
	
	static belongsTo = [member:Member]
	
    static constraints = {
		companyName nullable: true
		companyTitle nullable: true
		companyCultureContent nullable: true
		date nullable: true
		
		type nullable: true
		
		member nullable: true
    }
	
	String toString() {
		return this.companyName //+ " - " + this.spType + " - " + this.country
	}
}
