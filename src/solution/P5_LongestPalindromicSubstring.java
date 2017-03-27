package solution;

public class P5_LongestPalindromicSubstring {

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
