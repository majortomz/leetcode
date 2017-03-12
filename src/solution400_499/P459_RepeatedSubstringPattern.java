package solution400_499;

public class P459_RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String s) {
		if (s.length() <= 1)
			return false;
		int len = s.length() / 2; // the length of repeated substring
		while (len >= 1) {
			// 如果len无法被s的长度整除，则该len不可能
			if (s.length() % len != 0) {
				len--;
				continue;
			}
			// 以len为步长，选取子串，分别和第一个子串匹配
			String temp = s.substring(0, len);
			int count = 1, bound = s.length() - len;
			for (int k = len; k <= bound; k += len) {
				if (temp.equals(s.substring(k, k + len))) {
					count++;
				} else {
					break;
				}
			}
			if (count * len == s.length())
				return true;
			len--;
		}
		return false;
	}

	public static void main(String[] args) {
		P459_RepeatedSubstringPattern pr = new P459_RepeatedSubstringPattern();
		System.out.println(pr.repeatedSubstringPattern("ababab"));
	}
}
