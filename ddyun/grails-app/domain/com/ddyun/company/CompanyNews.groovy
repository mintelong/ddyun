package com.ddyun.company

import com.ddyun.security.Member

class CompanyNews {
	
	String title;
	String content;
	String logo;
	Date date;
	
	static belongsTo = [member:Member]
	CompanyCulture companyId;

    static constraints = {
		title nullable: true
		content nullable: true
		logo nullable: true
		date nullable: true
		
		member nullable: true
		companyId(blank : false)
    }
}
