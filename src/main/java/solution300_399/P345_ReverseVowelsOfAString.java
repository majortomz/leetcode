package solution300_399;

public class P345_ReverseVowelsOfAString {
	public String reverseVowels(String s) {
		char[] sc = s.toCharArray();
		boolean lv = false, rv = false;
		for (int i = 0, j = sc.length - 1; i < j;) {
			lv = isVowel(sc[i]);
			rv = isVowel(sc[j]);
			// 如果当前都为元音字母，则互换位置，然后i后移，j前移
			if(lv && rv)
			{
				char tmp = sc[i];
				sc[i] = sc[j];
				sc[j] = tmp;
				i++;
				j--;
			}
			// 否则，把不是元音字母的下标往中间移动
			else {
				i = lv==false?i+1:i;
				j = rv==false?j-1:j;
			}
		}
		return String.valueOf(sc);
	}
	
	public String reverseVowels2(String s) {
		char[] sc = s.toCharArray();
		for (int i = 0, j = sc.length - 1; i < j; i++, j--) {
			// 如果sc[i]不为元音字母，下标后移
			while(i<j && !isVowel(sc[i]))
				i++;
			// 如果sc[j]不为元音字母，下标前移
			while(i<j && !isVowel(sc[j]))
				j--;
			// 如果i<j则交换
			if(i<j)
			{
				char tmp = sc[i];
				sc[i] = sc[j];
				sc[j] = tmp;
			}
		}
		return String.valueOf(sc);
	}

	public boolean isVowel(char c) {
		boolean result = false;
		switch (c) {
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			result = true;
			break;
		default:
			result = false;
			break;
		}
		return result;
	}
}
