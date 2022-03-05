package com.sks.hawkeye.util;

public class CommonUtil {

	public static boolean isNotBlank(String str) {
		return str!=null && !"".equals(str);
	}
	public static boolean isNotBlank(Object str) {
		return str!=null;
	}
	public static boolean isNotBlank(int str) {
		return str!=0;
	}
	public static boolean isBlank(String str) {
		return !isNotBlank(str);
	}
	public static boolean isBlank(Object str) {
		return !isNotBlank(str);	
	}
	public static boolean isBlank(int str) {
		return !isNotBlank(str);	
	}
	public static String replaceSpecialChar(String str) {
		return str.replaceAll("-", " ");	
	}
	
}
