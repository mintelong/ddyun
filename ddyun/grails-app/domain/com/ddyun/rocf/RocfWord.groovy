package com.ddyun.rocf

import com.ddyun.security.Member

class RocfWord {
	
	String title;
	String content;
	Date date;
	
	static belongsTo = [member:Member]

    static constraints = {
		title nullable: true
		content nullable: true
		date nullable: true
		
		member nullable: true
    }
}
