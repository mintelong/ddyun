package com.ddyun.rocf

import java.util.Date;

class RocfCulture {
	
	String title;
	String content;
	Date date;

    static constraints = {
		title nullable: true
		content nullable: true
		date nullable: true

    }
}
