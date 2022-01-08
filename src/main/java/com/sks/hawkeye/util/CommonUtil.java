package com.sks.hawkeye.util;

public class CommonUtil {

	public static boolean isNotBlank(String str) {
		return str!=null && !"".equals(str);
	}
	public static boolean isNotBlank(Object str) {
		return str!=null;
	}
	
}
