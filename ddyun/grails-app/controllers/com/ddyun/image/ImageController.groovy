package com.ddyun.image

import com.ddyun.util.FileUtil

class ImageController {

    /**
	 * 保存图片信息
	 * @param null
	 * @return null
	 *
	 * **/
	def String imgSave(){
		
		def format = request.getHeader("format")
		def userAgent = request.getHeader("User-Agent")
		
		UUID uuid = UUID.randomUUID()
		String img = null
		def file
		try{
			for (String key : params.keySet()) {
				if(key.startsWith("upload")||key.contains("fileData")){
					file = params.get(key)
				}
			}
			
			if(file){
				double fileSize = file.size
				fileSize = fileSize / 1024  //以k作为计算单位
				img = FileUtil.imgSave(file.getBytes() , uuid.toString())
			}
		}catch(Exception e){
			return null
		}
		
		
		render "{\"success\":\"" + true + "\",\"file_path\":\"" + "/scfire/project/imgRead?img="+img + "\"}";
	}
}
