package com.zrui.ssh.converters;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class SSHDataconverters extends StrutsTypeConverter {

	private DateFormat dateFormat;
	
	{
		dateFormat =new SimpleDateFormat("yyyy-MM-dd");
	}
	
	/**
	 * 从String 转为目标类型
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(toClass == Date.class){
			try {
				return dateFormat.parse(values[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 
	 * 从目标类型转为String
	 */
	
	@Override
	public String convertToString(Map arg0, Object o) {
		if(o instanceof Date){
			return dateFormat.format(o);
		}
			
		return null;
	}

}
