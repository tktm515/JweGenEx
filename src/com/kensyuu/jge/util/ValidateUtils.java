package com.kensyuu.jge.util;

import java.text.SimpleDateFormat;

public class ValidateUtils {

	public boolean isDateFormat(String date) {
		    //日付のフォーマット確認
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		    try {
		        formatter.parse(date);//フォーマットチェック.日付に変換できるか（渡されたデータは）
		        return true;
		    } catch(Exception e) {
		        return false;
		    }
	}

	public boolean isTimeFormat(String time) {

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		    try {
		        formatter.parse(time);//フォーマットチェック.日付に変換できるか（渡されたデータは）
		        return true;
		    } catch(Exception e) {
		        return false;
		    }
	}

	public boolean isRengeLength(String str, int minLength, int maxLength) {

		int strLength = str.length();
	    if(minLength < strLength &&  strLength < maxLength ) { // min(1)<strLength<max(65)
	        return true;
	    } else {
	     return false;
	    }
	}
}