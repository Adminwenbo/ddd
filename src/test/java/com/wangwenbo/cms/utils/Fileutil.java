package com.wangwenbo.cms.utils;

public class Fileutil {

	public static String getExtendName(String fileName){
		int i = fileName.indexOf(".");
		String string = fileName.substring(i);		
		return string;
		//TODO 实现代码
		}
}
