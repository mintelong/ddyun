package com.ddyun.company

class CompanyCase {
	
	String name
	String description
	String logo
	Date date

    static constraints = {
		name nullable: true
		description nullable: true
		logo nullable: true
		date nullable: true
    }
}
