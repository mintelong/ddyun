package com.ddyun.company

import com.ddyun.security.Member
import java.util.Date;

class CompanyContact {
	
	String tel
	String address
	String officer
	String email
	Date date
	
	static belongsTo = [member:Member]

    static constraints = {
		tel nullable: true
		address nullable: true
		officer nullable: true
		email nullable: true
		date nullable: true
		
		member nullable: true
    }
}
