package com.kensyuu.jge.util;

public class StringUtils {
	/**
	 *  引数で渡される日付を表す文字列を
	 *  画面表示用の形式に整形します。
	 *  引数で渡される文字列の形式は、yyyy-MM-dd hh:mm:ss を想定しています。
	 *
	 * @param inputDate
	 *            日付を表す文字列 形式(yyyy-MM-dd hh:mm:ss)
	 * @return 画面表示用の日付形式 (yyyy-MM-dd)
	 *
	 */
	public static String formatDateForView(String inputDate) {
		if(inputDate == null){
			inputDate = "**********";
			return inputDate;
		}
		return inputDate.substring(0, 10);
	}

	/**
	 * 文字列に含まれるHTML特殊文字をエスケープ変換して返します。
	 *
	 * @param	beforeStr	変換元文字列
	 *
	 * @return	変換後文字列
	 */
	public static String toHtmlString(String beforeStr) {
		if (beforeStr == null) {
			return "";
		}
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < beforeStr.length(); i++) {
			char originalCharacter = beforeStr.charAt(i);
			switch (originalCharacter) {
				case '&':
					buff.append("&amp;");
					break;
				case '<':
					buff.append("&lt;");
					break;
				case '>':
					buff.append("&gt;");
					break;
				case '"':
					buff.append("&quot;");
					break;
				case '\'':
					buff.append("&#39;");
					break;
				case '\\':
					buff.append("&yen;");
					break;
				default:
					buff.append(originalCharacter);
					break;
			}
		}
		return buff.toString();
	}
}
