package com.beerrun.common;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class ArchUtils {
	public static boolean isIntValue(String val)
	{
		try {
			val=val.replace(" ","");
			Integer.parseInt(val);
		} catch (Exception e) {return false;}
		return true;
	}
	public static String nulltoIntegerDefalt(String value){
		if(!isIntValue(value)) value="0";
		return nulltoNumericDefalt(value,"0");
		
	}
	public static boolean isfloatValue(String val)
	{
		try {
			val=val.replace(" ","");
			Double.parseDouble(val);
		} catch (Exception e) {return false;}
		return true;
	}
public static String nulltoNumericDefalt(String value,String replacevalue){
		
		if(isfloatValue(value)){
			value=value.replace(" ","");
		}
		else if(!replacevalue.equalsIgnoreCase(""))
		{
			value =replacevalue;
		}
		return value;
	}

	public static File MoveToFileServer(MultipartFile multipart,String uploadPath) throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		Date dNow = new Date();
		SimpleDateFormat simpledata = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String date = simpledata.format(dNow);
		String name = "pactpub_" + date + "_" + multipart.getOriginalFilename();
		multipart.transferTo(convFile);
		File destFile = new File(uploadPath, name);
		FileUtils.copyFile(convFile, destFile);
		return convFile;
	}
	
	public static Map<String,?> ListToLinkedHashMap(List<?> source,List<String> keyvalue,String keyconcatstring)
	{
		Map<String,Object> desMap=new LinkedHashMap<String,Object>();
		keyconcatstring=keyconcatstring.equalsIgnoreCase("")?"#":keyconcatstring;
		try {
			for(Object sourcebean:source)
			{
				boolean isfirst=true;
				String key="";
				
				for(String fieldvalue:keyvalue){
					Object value = new PropertyDescriptor(fieldvalue, sourcebean.getClass()).getReadMethod().invoke(sourcebean);
					if(value!=null)
					if(isfirst)	{
						key=value.toString();
						isfirst=false;
					}
					else
					{
						key=key+keyconcatstring+value.toString();
					}
				}
				desMap.put(key, sourcebean);
			}
		} 
		catch (Exception e) {e.printStackTrace();}
		return desMap;
	}
	public static String nullCheck(String val){
		return nullCheck(val,"");
	}
	public static String nullCheck(String val,String replaceVal){
		String str="";
		str=StringUtils.isEmpty(val)?replaceVal:val;
		str=str.equalsIgnoreCase("null")?"":str;
		return str;
	}
	public static List<String> getTokensList(String str, String delimeter) {  
		   return Arrays.asList(StringUtils.split(str,delimeter));  
		 } 
	
	public static String getStringArrayToString(Object[] array,String separator) { 
		if (array==null || array.length==0) return ""; 
	   return StringUtils.join(array, separator);  
	 }  
	
	public static String getJspModalHeader()
	{
		return getJspModalHeader("");
	}
	public static String getJspModalHeader(String width)
	{
		String Style=width.equalsIgnoreCase("")?"":"1"; 
		
		String msg="<!-- modal Header Start --><div class='modal-dialog"+Style+"'><div class='modal-content'>" +
				"<div class='modal-header'>"
				 +"<button type='button' class='close' data-dismiss='modal' aria-label='Close'>"
			     +"<span aria-hidden='true'>&times;</span></button>"
			     +"<h4 class='modal-title'>E</h4></div>"
				 +" <div class='modal-body no-padding'><!-- modal Header End -->";
		return msg;
	}
	public static String getJspModalFooter()
	{
		String msg="<!-- modal Footer Start --></div></div></div><!-- modal Footer End -->";
		return msg;
	}
	
	public static String getCurrentDate(boolean withtime){
		Date dt = Calendar.getInstance().getTime();
		String format="dd-MM-yyyy";
		format=withtime? format+" HH:mm:ss":format;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		return dateFormat.format(dt);
	}
	
	
}
