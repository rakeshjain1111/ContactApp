package com.rakesh.capp.utility;

public class StringUtil{
	public static String toCommaSeparateString(Integer[] contactIds) {
		StringBuffer sb =new StringBuffer();
		for(Object item:contactIds){
			sb.append(item).append(",");
		}
		if(sb.length()>0) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
}


