package com.ddyun.company

class CompanyProduct {
	
	String name;
	String title;
	String logo;
	double price;
	Date date;

    static constraints = {
		name nullable: true
		title nullable: true
		logo nullable: true
		price nullable: true
		date nullable: true
    }
}
