package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P49_GroupAnagrams {

	public List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> result = new LinkedList<List<String>>();
		for(String s:strs){
			char[] sc = s.toCharArray();
			Arrays.sort(sc);
			String key = new String(sc);
			if(!map.containsKey(key))
			{
				List<String> list = new LinkedList<String>();
				map.put(key, list);
			}
			map.get(key).add(s);
		}
		for(List<String> list: map.values())
			result.add(list);
		return result;
	}
	
	// TLE
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		boolean visit[] = new boolean[strs.length];
		int strCount[][] = new int[strs.length][];
		for(int i=0; i<strs.length; i++)
			strCount[i] = count(strs[i]);
		for(int i=0; i<strs.length; i++)
		{
			if(visit[i] == true)	continue;
			visit[i] = true;
			List<String> group = new ArrayList<String>();
			group.add(strs[i]);
			for(int j=i+1; j<strs.length; j++)
			{
				if(visit[j] == true)	continue;
				if(compare(strCount[i], strCount[j]))
				{
					visit[j] = true;
					group.add(strs[j]);
				}
			}
			result.add(group);
		}
		return result;
	}
	
	public int[] count(String s){
		int[] result = new int[26];
		for(int i=0; i<s.length(); i++)
		{
			result[s.charAt(i) - 'a'] += 1;
		}
		return result;
	}
	
	public boolean compare(int a[], int b[]){
		for(int i=0; i<a.length; i++)
		{
			if(a[i] != b[i])	return false;
		}
		return true;
	}
}
