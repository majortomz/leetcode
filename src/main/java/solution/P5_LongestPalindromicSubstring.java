package solution;

public class P5_LongestPalindromicSubstring {

	// Solution 4: 最长公共子串 TLE
	private class Solution4 {
		public String longestPalindrome(String s) {
			if(s == null || s.length() == 0)	return s;
			String s2 = new StringBuilder(s).reverse().toString();
			int len = s.length();
			int[][] dp = new int[len + 1][len + 1];
			int rt = 0, max = 0;
			for(int i = 1; i <= len; i++) {
				for(int j = 1; j <= len; j++) {
					if(s.charAt(i - 1) == s2.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
					if(dp[i][j] > max) {
						String sub = s.substring(i - dp[i][j], i);
						if(sub.equals(new StringBuilder(sub).reverse().toString())) {
							max = dp[i][j];
							rt = i - 1;
						}

					}
				}
			}
			return s.substring(rt - max + 1, rt + 1);
		}
	}

	// Solution 3: DP
	private class Solution3 {
		public String longestPalindrome(String s) {
			if(s == null || s.length() == 0)    return s;
			char[] words = s.toCharArray();
			// dp[i][j] records whether s[i, j] is palindrome.
			boolean[][] dp = new boolean[words.length][words.length];
			int lt = 0, rt = 0, max = 1;

			dp[0][0] = true;
			for(int i = 1; i < words.length; i++) {
				dp[i][i] = true;
				dp[i - 1][i] = (words[i - 1] == words[i]);
				if(dp[i - 1][i])  {
					lt = i - 1;
					rt = i;
					max = 2;
				}
			}

			for(int len = 3; len <= words.length; len++) {
				for(int j = len - 1; j < words.length; j++) {
					int i = j - len + 1;
					dp[i][j] = (words[i] == words[j] && dp[i + 1][j - 1]);
					if(dp[i][j] && len > max) {
						max = len;
						lt = i;
						rt = j;
					}
				}
			}
			return s.substring(lt, rt + 1);
		}
	}

	// Solution2
	public String longestPalindrome2(String s) {
		if(s==null || s.length() == 0)	return s;
		int start = 0, end = 0, max = 0;
		for(int i=0; i<s.length(); i++)
		{
			int lt, rt, len;
			lt = i-1; rt = i+1;
			len = 1;
			while(lt>=0 && rt<s.length() && s.charAt(lt) == s.charAt(rt))
			{
				lt--; rt++; len+=2;
			}
			if(len>max)
			{
				max = len;	start = lt+1; end = rt-1;
			}
			lt = i; rt = i+1; len=0;
			while(lt>=0 && rt<s.length() && s.charAt(lt) == s.charAt(rt))
			{
				lt--; rt++; len+=2;
			}
			if(len>max)
			{
				max = len;	start = lt+1; end = rt-1;
			}
		}
		return s.substring(start, end+1);
	}
	
	// Solution1: TLE
	public String longestPalindrome(String s) {
		if (s.isEmpty())
			return "";
		int start = 0, end = 0, max_len = 1;
		for (int i = 0; i < s.length() - max_len; i++) {
			for (int j = i + max_len; j < s.length(); j++) {
				if (isPalind(s.substring(i, j + 1)) && (j - i + 1) > max_len) {
					start = i;
					end = j;
					max_len = j - i + 1;
				}
			}
		}
		return s.substring(start, end+1);
	}

	public boolean isPalind(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) == s.charAt(len - i - 1))
				continue;
			else
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String test = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotl"
				+ "iyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdy"
				+ "vnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusg"
				+ "jwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwru"
				+ "obfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
		P5_LongestPalindromicSubstring pl = new P5_LongestPalindromicSubstring();
		System.out.println(test + "\n" + pl.longestPalindrome2("cbbd"));
	}
}
