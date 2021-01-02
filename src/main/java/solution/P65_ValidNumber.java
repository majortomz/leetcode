package solution;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class P65_ValidNumber {

	/**
	 * 首先要去除两端的空格
	 * [整数部分][. 小数点可有可无][小数部分，可有可无][指数部分，可有可无]
	 * [.][小数部分][指数部分部分，可有可无]
	 */
	public boolean isNumber(String s) {
		if(s == null)	return false;
		s = s.trim();
		if(s.length() == 0)	return false;
		Pattern ptn = Pattern.compile("[+-]?(\\d+)(\\.)?(\\d+)?(e[+-]?\\d+)?|[+-]?(\\.\\d+)(e[+-]?\\d+)?");
		Matcher mat = ptn.matcher(s.trim());
		return mat.matches();
	}

	/*
		"1.0 "	true
		".52"	true
		"    "  false
		"3. "	true
		"e10"	false
	 */
	public static void main(String[] args) {
		P65_ValidNumber pv = new P65_ValidNumber();
		System.out.println(pv.isNumber("e10"));
	}
}
