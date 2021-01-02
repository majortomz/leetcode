package solution;

public class P91_DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int n[] = new int[s.length() + 1];
		int index;
		n[0] = 1;
		n[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 1; i < s.length(); i++) {
			index = i + 1;
			if (s.charAt(i) != '0')
				n[index] = n[index - 1];
			if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))
				n[index] += n[index - 2];
		}
		return n[s.length()];
	}

	/*
	 * "" "0", "1", "12245",
	 */
	public static void main(String[] args) {
		P91_DecodeWays pd = new P91_DecodeWays();
		System.out.println(pd.numDecodings("9009"));
	}
}
