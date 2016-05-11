package com.ddyun.rocf

import java.util.Date;

class RocfNews {
	
	String title;
	String content;
	String logo;
	Date date;

    static constraints = {
		title nullable: true
		content nullable: true
		logo nullable: true
		date nullable: true
    }
}
