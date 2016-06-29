package com.ddyun.dataCenter

import com.ddyun.security.Member

class Words {
	
	//存储表名
	String title
	//描述
	String words
	
	String reply
	
	static belongsTo = [member:Member]

    static constraints = {
		
		title nullable: true
		words nullable: true
		reply nullable: true
		
		member nullable: true
    }
}
