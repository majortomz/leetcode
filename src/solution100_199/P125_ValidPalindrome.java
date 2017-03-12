package solution100_199;

public class P125_ValidPalindrome {
	public boolean isPalindrome(String s) {
		if(s == null || s.length() == 0)	return true;
		char sc[] = s.toLowerCase().toCharArray();
		for(int i=0, j=sc.length-1; i<j; i++, j--)
		{
			while(i<j && !Character.isAlphabetic(sc[i]) && !Character.isDigit(sc[i]) )
				i++;
			while(i<j && !Character.isAlphabetic(sc[j]) && !Character.isDigit(sc[j]) )
				j--;
			if(i==j || (i<j && sc[i] == sc[j]))
			{
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
}
