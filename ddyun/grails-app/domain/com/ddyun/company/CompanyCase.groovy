package com.ddyun.company

class CompanyCase {
	
	String name
	String description
	String logo
	String url
	Date date
	CompanyCulture companyId;

    static constraints = {
		name nullable: true
		description nullable: true
		logo nullable: true
		url nullable: true
		date nullable: true
		companyId(blank : false)
    }
}
