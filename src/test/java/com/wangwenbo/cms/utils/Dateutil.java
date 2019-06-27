package com.wangwenbo.cms.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dateutil {

	
	public static Date getDateByInitMonth(Date src){
		
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		
		String string = format.format(src);
		
		ParsePosition position = new ParsePosition(8);
		Date date = format.parse(string, position);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//将小时至0
		calendar.set(Calendar.HOUR_OF_DAY,0);
		//将分钟至0
		calendar.set(Calendar.MINUTE, 0);
		//将秒至0
		calendar.set(Calendar.SECOND, 0);
		//将毫秒至0
		calendar.set(Calendar.MILLISECOND, 0);
		
		return date;
		//TODO 实现代码
		}
	
	
	public static Date getDateByFullMonth(Date src){
		
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		
		String string = format.format(src);
		ParsePosition position = new ParsePosition(0);
		Date date = format.parse(string, position);
		
		
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(src);
		
		//设置为本月的最后一天
		c.set(Calendar.DAY_OF_MONTH,c.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		//将小时设成23
		c.set(Calendar.HOUR_OF_DAY, 23);
		
		//将分钟设置为59
		c.set(Calendar.MINUTE, 59);
		
		//将秒设置为59
		c.set(Calendar.SECOND, 59);
		
		//将毫秒设置成999
		c.set(Calendar.MILLISECOND, 999);
		return date;
		//TODO 实现代码
	}
	
	
	public static void main(String[] args) {
		Date date = getDateByInitMonth(new Date());
		
		System.out.println(date);
	}
}
