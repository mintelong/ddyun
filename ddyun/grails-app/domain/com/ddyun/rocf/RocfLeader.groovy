package com.ddyun.rocf

import java.util.Date;

class RocfLeader {
	
	String name;
	String englishName;
	String title;
	String shortResume;
	String longResume;
	String logo;
	Date date;

    static constraints = {
		name nullable: true
		englishName nullable: true
		title nullable: true
		shortResume nullable: true
		longResume nullable: true
		logo nullable: true
		date nullable: true
    }
}
