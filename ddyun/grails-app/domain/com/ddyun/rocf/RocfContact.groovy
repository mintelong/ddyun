package com.ddyun.rocf

import java.util.Date;
import com.ddyun.security.Member

class RocfContact {
	
	String tel;
	String address;
	String officer;
	String email;
	Date date;
	
	static belongsTo = [member:Member]

    static constraints = {
		tel nullable: true
		address nullable: true
		officer nullable: true
		email nullable: true
		date nullable: true
		
		member nullable: true
    }
}
