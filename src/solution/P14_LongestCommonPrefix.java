package solution;

import java.util.Arrays;

public class P14_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)	return "";
		if(strs.length == 1)	return strs[0];
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		int len = Integer.MAX_VALUE, i = 0;
		for(int k=0; k<strs.length; k++)
		{
			len = len<strs[k].length()?len:strs[k].length();
		}
		while(flag && i<len)
		{
			char c = strs[0].charAt(i);
			for(int k=1; k<strs.length; k++)
			{
				if(strs[k].charAt(i) != c)
				{
					flag = false;
					break;
				}
			}
			if(flag == false) break;
			i++;
			sb.append(c);
		}
		return sb.toString();
	}
	
	public String longestCommonPrefix2(String[] strs){
		if(strs == null)	return null;
		if(strs.length == 0)	return "";
		Arrays.sort(strs);
		int i = 0, len1 = strs[0].length(), len2 = strs[strs.length-1].length();
		int min = Math.min(len1, len2);
		while(i < min)
		{
			if(strs[0].charAt(i) != strs[strs.length-1].charAt(i))	break;
			i++;
		}
		return strs[0].substring(0, i);
	}
}
