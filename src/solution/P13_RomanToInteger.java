package solution;

import java.util.HashMap;

public class P13_RomanToInteger {

	public int romanToInt(String s) {
		char[] rc = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int[] rv = {1, 5, 10, 50, 100, 500, 1000};
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0; i<rc.length; i++)
			hm.put(rc[i], rv[i]);
		
		int result = 0;
		for(int i =0; i<s.length(); i++)
		{
			if(i+1 < s.length() && hm.get(s.charAt(i)) < hm.get(s.charAt(i+1)))
				result -= hm.get(s.charAt(i));
			else
				result += hm.get(s.charAt(i));
		}
		return result;
	}
}
