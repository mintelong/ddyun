package com.ddyun.company

class CompanyNews {
	
	String title;
	String content;
	String logo;
	Date date;
	CompanyCulture companyId;

    static constraints = {
		title nullable: true
		content nullable: true
		logo nullable: true
		date nullable: true
		companyId(blank : false)
    }
}
