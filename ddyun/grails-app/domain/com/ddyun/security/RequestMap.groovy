package com.ddyun.security

import org.springframework.http.HttpMethod

class RequestMap {
	
	String url
	String configAttribute
	HttpMethod httpMethod

	static mapping = {
		cache true
	}

	static constraints = {
		url blank: false, unique: 'httpMethod'
		configAttribute blank: false
		httpMethod nullable: true
	}
	
	static RequestMap create(String url, String configAttribute, boolean flush = false) {
		def instance
		if(!RequestMap.findByUrlAndConfigAttribute(url,configAttribute)){
			instance = new RequestMap(url: url, configAttribute: configAttribute)
			instance.save(flush: flush, insert: true)
			
		}
		instance
	}
	
}
