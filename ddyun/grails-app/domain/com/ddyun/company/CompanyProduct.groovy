package com.ddyun.company

import com.ddyun.security.Member

class CompanyProduct {
	
	String name;
	String title;
	String logo;
	double price;
	Date date;
	
	static belongsTo = [member:Member]

    static constraints = {
		name nullable: true
		title nullable: true
		logo nullable: true
		price nullable: true
		date nullable: true
		
		member nullable: true
    }
}
