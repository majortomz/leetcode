package solution200_299;

import java.util.HashMap;
import java.util.Map;

public class P242_ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;
		Map<Character, Integer> sFreq = new HashMap<>();
		for(int i=0; i<s.length(); i++)
		{
			if(sFreq.containsKey(s.charAt(i)))
				sFreq.put(s.charAt(i), sFreq.get(s.charAt(i))+1);
			else
				sFreq.put(s.charAt(i), 1);
		}
		for(int i=0; i<t.length(); i++)
		{
			if(!sFreq.containsKey(t.charAt(i)) || sFreq.get(t.charAt(i))<=0)
				return false;
			sFreq.put(t.charAt(i), sFreq.get(t.charAt(i))-1);
		}
		return true;
    }
	
	public boolean isAnagram2(String s, String t) {
		if(s.length() != t.length())
			return false;
		int[] freq = new int[256];
		for(int i=0; i<s.length(); i++)
			freq[s.charAt(i)] += 1;
		for(int i=0; i<t.length(); i++)
		{
			if(freq[t.charAt(i)] <= 0)
				return false;
			freq[t.charAt(i)]--;
		}
		return true;
    }
}
