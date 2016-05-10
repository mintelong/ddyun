/**
 * 
 */
package com.ddyun.common

/**
 * @author zwl
 *
 */
class FileHandle {
	static getFilenameExtention(String filename){
		return filename.substring( filename.lastIndexOf(".") + 1).toLowerCase()
	}
	
	static catchFocusRandomNum(){
		int max=100
		int min=5
		Random random = new Random()
		int s = random.nextInt(max)%(max-min+1) + min
		return s
	}
	
	static catchBrowseRandomNum(){
		int max=100
		int min=5
		Random random = new Random()
		int s = random.nextInt(max)%(max-min+1) + min
		return s
	}
	
	static main(args) {
		println(catchFocusRandomNum())
	}
}
