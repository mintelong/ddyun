package com.ddyun.rocf

import java.util.Date;

class RocfContact {
	
	String tel;
	String address;
	String officer;
	String email;
	Date date;

    static constraints = {
		tel nullable: true
		address nullable: true
		officer nullable: true
		email nullable: true
		date nullable: true
    }
}
