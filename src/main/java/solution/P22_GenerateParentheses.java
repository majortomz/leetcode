package solution;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class P22_GenerateParentheses {
	/*
	 * 长度为n的合法 
	 */
	public List<String> generateParenthesis(int n) {
		ArrayList<Set<String>> result = new ArrayList<Set<String>>();
		Set<String> rSet = new HashSet<String>();
		rSet.add("");
		result.add(rSet);
		int i = 0;
		while(i < n){
			i++;
			rSet = new HashSet<String>();
			for(int j = 1; j<i; j++)
			{
				int k = i - j;
				for(String sa: result.get(j))
				{
					for (String sb: result.get(k))
						rSet.add(sa + sb);
				}
			}
			for(String sa: result.get(i-1))
				rSet.add("(" + sa + ")");
			result.add(rSet);
		}
		ArrayList<String> as = new ArrayList<String>();
		as.addAll(result.get(n));
		return as;
	}
	
	public static void main(String[] args){
		int[] test_case = {0, 1, 2, 3, 4};
		P22_GenerateParentheses pg = new P22_GenerateParentheses();
		for(int i : test_case)
		{
			System.out.println(i + " " + pg.generateParenthesis(i) + " " + pg.generateParenthesis(i).size());
		}
	}
}
