package com.ddyun.company

import java.util.Date;

class CompanyContact {
	
	String tel
	String address
	String officer
	String email
	Date date
	CompanyCulture companyId;

    static constraints = {
		tel nullable: true
		address nullable: true
		officer nullable: true
		email nullable: true
		date nullable: true
		companyId(blank : false)
    }
}
