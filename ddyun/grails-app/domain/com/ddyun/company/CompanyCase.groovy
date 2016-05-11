package com.ddyun.company

import com.ddyun.security.Member

class CompanyCase {
	
	String name
	String description
	String logo
	Date date
	
	static belongsTo = [member:Member]

    static constraints = {
		name nullable: true
		description nullable: true
		logo nullable: true
		date nullable: true
		
		member nullable: true
    }
}
