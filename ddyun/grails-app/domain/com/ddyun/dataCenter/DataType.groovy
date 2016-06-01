package com.ddyun.dataCenter

import java.util.SortedSet;

class DataType {
	
	//类型名称
	String name
	//类型代码
	String code
	
	//文章
	SortedSet dataInfos
	static hasMany = [dataInfos:DataInfo]
	
    static constraints = {
		name nullable:true
		code nullable:true
		
		dataInfos nullable:true
    }
	
}
