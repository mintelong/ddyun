package com.ddyun.dataCenter

import java.util.SortedSet;

import com.ddyun.security.Member

class DataInfo implements Comparable {
	
	//存储表名
	String tablename
	//描述
	String describe
	//数据类型DB/MAP/TXT
	String type
	
	//是否公开
	boolean ispublish
	//访问次数
	int visitnum
	
	//逻辑删除标识
	boolean isdelete
	
	//存储数据表字段名称 以,分隔
	String fieldname
	//存储数据表字段数
	int fieldnum
	//文章
	SortedSet dataDetails
	
	static belongsTo = [dataType:DataType,member:Member]
	static hasMany = [dataDetails:DataDetail]
	
	static mapping = {
		dataDetails lazy:false
		dataDetails batchSize:5
	}
		
    static constraints = {
		tablename nullable:true
		describe nullable:true
		type nullable:true
		ispublish nullable:true
		visitnum nullable:true
		isdelete nullable:true
		fieldname nullable:true
		fieldnum nullable:true
		
		dataType nullable:true
		member nullable:true
		
		dataDetails nullable:true
		
    }
	
	
	
	public int compareTo(Object o) {
		try{
			o.id(o?.id)
		}catch(Exception e){
			return 1
		}
	}
}
