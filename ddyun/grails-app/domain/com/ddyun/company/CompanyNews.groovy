package com.ddyun.company

import com.ddyun.security.Member

class CompanyNews {
	
	String title;
	String content;
	String logo;
	Date date;
	String username;
	static belongsTo = [member:Member]

    static constraints = {
		title nullable: true
		content nullable: true
		logo nullable: true
		date nullable: true
		username nullable: true
		member nullable: true
    }
}
