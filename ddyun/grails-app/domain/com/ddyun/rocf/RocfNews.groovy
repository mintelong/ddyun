package com.ddyun.rocf

import java.util.Date;
import com.ddyun.security.Member

class RocfNews {
	
	String title;
	String content;
	String logo;
	Date date;
	
	static belongsTo = [member:Member]

    static constraints = {
		title nullable: true
		content nullable: true
		logo nullable: true
		date nullable: true
		
		member nullable: true
    }
}
