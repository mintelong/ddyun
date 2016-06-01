package com.ddyun.dataCenter

class DataDetail implements Comparable {
	
	//默认允许最多20个字段
	
	//字段值1.。。。。。。20
	String value1
	String value2
	String value3
	String value4
	String value5
	String value6
	String value7
	String value8
	String value9
	String value10
	String value11
	String value12
	String value13
	String value14
	String value15
	String value16
	String value17
	String value18
	String value19
	String value20
	
	static belongsTo = [dataInfo:DataInfo]

    static constraints = {
		
		value1 nullable:true
		value2 nullable:true
		value3 nullable:true
		value4 nullable:true
		value5 nullable:true
		value6 nullable:true
		value7 nullable:true
		value8 nullable:true
		value9 nullable:true
		value10 nullable:true
		value11 nullable:true
		value12 nullable:true
		value13 nullable:true
		value14 nullable:true
		value15 nullable:true
		value16 nullable:true
		value17 nullable:true
		value18 nullable:true
		value19 nullable:true
		value20 nullable:true
		
		dataInfo nullable:true
    }
	
	public int compareTo(Object o) {
		try{
			o.id(o?.id)
		}catch(Exception e){
			return 1
		}
	}
}
