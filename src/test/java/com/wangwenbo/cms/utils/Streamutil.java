package com.wangwenbo.cms.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Streamutil {

	public static void closeAll(Closeable ...closeables ){
		//TODO 实现代码
		
		for (Closeable closeable : closeables) {
			if (closeable !=null) {
				try {
					closeable.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	
	
	//传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	public static String readTextFile(InputStream src){
		
		BufferedInputStream inputStream=new BufferedInputStream(src);
		
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		
		byte [] buff=new byte[1024];
		int leng=0;
		
		try {
			while ((leng=inputStream.read(buff))!=-1) {
				outputStream.write(buff, 0, leng);
			}
			
			byte[] bs = outputStream.toByteArray();
			closeAll(inputStream,outputStream);
			
			return bs.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeAll();
		return null;
		//TODO 实现代码
		}
	
	
	
	//方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。
	public static String readTextFile(File txtFile) throws FileNotFoundException{
		
		FileInputStream stream = new FileInputStream(txtFile);
		
		String string = readTextFile(stream);
		
		return string;
				
	}
}
