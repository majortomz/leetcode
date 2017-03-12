package mytry;

import java.util.Arrays;

public class KMP {

	/**
	 * 
	 * @param t:
	 *            text string
	 * @param p:
	 *            pattern string
	 * @return
	 */
	public int kmp(String t, String p) {
		int m = t.length(), n = p.length();
		int pre[] = computePrefix(p), len = -1;
		System.out.println(Arrays.toString(pre));
		for (int i = 0; i < m; i++) {
			while (len >= 0 && t.charAt(i) != p.charAt(len + 1))
				len = pre[len];
			if (t.charAt(i) == p.charAt(len + 1))
				len++;
			System.out.println(t.charAt(i));
			if (len + 1 == n)
				return i - len;
		}
		return -1;
	}

	public int[] computePrefix(String p){
		int[] prefix = new int[p.length()];
		int k = -1;
		prefix[0] = -1;
		for(int i=1; i<p.length(); i++)
		{
			while(k >=0 && p.charAt(i) != p.charAt(k+1))
				k = prefix[k];
			if(p.charAt(i) == p.charAt(k + 1))
				k++;
			prefix[i] = k;
		}
		return prefix;
	}

	public static void main(String[] args) {
		String s = "bacbababacabcbab", p = "ababaca";
		KMP kmp = new KMP();
		int pos = kmp.kmp(s, p);
		System.out.println(pos);
		System.out.println(s.substring(pos, pos + p.length()));
	}
}
