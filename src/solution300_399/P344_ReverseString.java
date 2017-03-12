package solution300_399;

public class P344_ReverseString {
	
	public String reverseString(String s){
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
	
	public String revereString2(String s){
		char[] sc = new char[s.length()];
		for(int i=s.length()-1; i>=0; i--)
		{
			sc[s.length()-i-1] = s.charAt(i);
		}
		String result = new String(sc);
		return result;
	}
}
