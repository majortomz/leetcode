package solution500_599;

public class P541_ReverseString2 {

	public String reverseStr(String s, int k) {
		char[] sc = new char[s.length()];
		int end = 0;
		for(int i=0; i<s.length(); i = end)
		{
			end = i+k;
			end = end>=s.length()?s.length():end;
			for(int j=i; j<end; j++)
				sc[i + end - j -1] = s.charAt(j);
			end = i+ 2 * k;
			end = end>=s.length()?s.length():end;
			for(int j = i+k; j<end; j++)
				sc[j] = s.charAt(j);
		}
		String result = new String(sc);
		return result;
	}
	
	public static void main(String[] args){
		P541_ReverseString2 pr = new P541_ReverseString2();
		System.out.println(pr.reverseStr("abc", 2));
	}
}
