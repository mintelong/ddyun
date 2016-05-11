package com.ddyun.rocf

class RocfWord {
	
	String title;
	String content;
	Date date;

    static constraints = {
		title nullable: true
		content nullable: true
		date nullable: true
    }
}
