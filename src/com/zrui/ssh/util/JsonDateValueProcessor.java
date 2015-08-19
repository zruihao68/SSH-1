package com.zrui.ssh.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
/**
 *  实现Date 类型转换json处理类
 * @createTime 2015-07-27 10:18
 * @author 周睿
 *
 */
public class JsonDateValueProcessor implements JsonValueProcessor {
	
	private  String format = "yyyy-mm-dd";    //默认日期格式
	
	public JsonDateValueProcessor(String format){
		this.format=format;
	}
	public JsonDateValueProcessor(){
		
	}
	
	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
	
		return process(arg0);
	}

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		
		return process(arg1);
	}
	/**
	 * 
	 * 类型转换方法
	 * 
	 */
	private  Object process(Object value){
		if(value instanceof Date){           //判断类型
			//将日期格式化
			SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.UK);
			return sdf.format(value);
		}
		return value == null ? "" : value.toString();
	}

}
