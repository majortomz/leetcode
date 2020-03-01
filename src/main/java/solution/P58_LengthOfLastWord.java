package solution;

public class P58_LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
		int len = 0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i) != ' ')
			{
				if(i==0 || s.charAt(i-1) == ' ')
					len = 1;
				else 
					len++;
			}
		}
		return len;
	}
	
	public int lengthOfLastWord2(String s) {
		int len = 0, i = s.length()-1;
		while(i>=0 && s.charAt(i) == ' ')
			i--;
		while(i>=0 && s.charAt(i) != ' ')
		{
			i--;
			len++;
		}
		return len;
	}
}
