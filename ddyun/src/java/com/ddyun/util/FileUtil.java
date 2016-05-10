package com.ddyun.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;


/**
 * 上传，下载文件保存到本地服务器硬盘上
 * @author lhzeng
 *
 */
public class FileUtil {
	public static String imgSave(byte [] bytes , String uuid){
		try{
			File filePath = new File(DDYUNConstants.IMG_DIR);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			
			if(bytes!=null){
				FileOutputStream fo = new FileOutputStream(DDYUNConstants.IMG_DIR+uuid.toString());
				fo.write(bytes);
				fo.flush();
				fo.close();
				return uuid.toString();
			}
		}catch(Exception e){
			System.out.println("文件保存异常"+e.toString());
		}
		return null;
	}
	public static byte[] imgRead(String name){
		try {
		File file = new File(DDYUNConstants.IMG_DIR+name);
			if(file.exists()){
				FileInputStream fis = new FileInputStream(file);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b = new byte[1000];  
	            int n;  
	            while ((n = fis.read(b)) != -1) {  
	                bos.write(b, 0, n);  
	            }
	            fis.close();  
	            bos.close();  
	            return bos.toByteArray();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**  批量导出图片到文件夹
	public static void exportImgToDir() throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Mongo mongo =new Mongo("121.40.62.73", 27017);
		DB db = mongo.getDB("SCFIREDevDB");
		
		GridFS gridFS = new GridFS(db);
		DBCursor sor = gridFS.getFileList();
		Iterator<DBObject> it = sor.iterator();
		
		Field _fs = GridFSFile.class.getDeclaredField("_fs"); // _fs字段所在的类为GridFSFile 
		_fs.setAccessible(true); 
		int i = 1;
		while(it.hasNext()){
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			GridFSDBFile file = (GridFSDBFile)it.next();
			_fs.set(file, gridFS); 
			 String fileName = file.getFilename();
             String contentType = file.getContentType();
             String id = file.getId().toString();
             file.writeTo(byteArrayOutputStream);
             
             imgSave(byteArrayOutputStream.toByteArray() , id);
             System.out.print(i+"  ");
             byteArrayOutputStream.close();
			i++;
		}
		System.out.println("导出完成");
	}
	*/

}
