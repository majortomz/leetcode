package solution;

public class P28_ImplementStrStr {

	public int strStr(String haystack, String needle) {
		if(needle.length() == 0)
			return 0;
		int m = haystack.length(), n = needle.length();
		int[] pre = computePrefix(needle);
		int len = -1;  // the length of matched string substarct 1
		for(int i=0; i<m; i++)
		{
			while(len >= 0 && haystack.charAt(i) != needle.charAt(len+1))
				len = pre[len];
			if(haystack.charAt(i) == needle.charAt(len+1))
				len++;
			if(len+1 == n)
				return i-len;
		}
		return -1;
	}
	
	public int[] computePrefix(String pattern) {
		int[] prefix = new int[pattern.length()];
		int k = -1;
		prefix[0] = -1;
		for(int i=1; i<pattern.length(); i++)
		{
			while(k >=0 && pattern.charAt(i) != pattern.charAt(k+1))
				k = prefix[k];
			if(pattern.charAt(i) == pattern.charAt(k+1))
				k++;
			prefix[i] = k;
		}
		return prefix;
	}
	
	public int strStr2(String haystack, String needle) {
		int m = haystack.length(), n = needle.length();
		for(int i=0; i<=m - n; i++)
		{
			for(int j = 0; ; j++)
			{
				if(j == n)	return i;
				if(needle.charAt(j) == haystack.charAt(i+j))
					continue;
				else
					break;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		String s = "bacbababacabcbab", p = "ababaca";
		P28_ImplementStrStr pi = new P28_ImplementStrStr();
		int pos = pi.strStr2(s, p);
		System.out.println(s.substring(pos, pos+p.length()));
	}
}
