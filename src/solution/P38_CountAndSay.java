package solution;

public class P38_CountAndSay {

	public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder("1");
		for(int i=2; i<=n; i++)
		{
			sb = count(sb);
		}
		return sb.toString();
	}
	
	public StringBuilder count(StringBuilder s){
		StringBuilder sb = new StringBuilder();
		char pre;
		int count = 0;
		for(int i=0; i<s.length();)
		{
			pre = s.charAt(i);
			count = 0;
			while(i<s.length() && s.charAt(i) == pre)
			{
				count++;
				i++;
			}
			sb.append(count);
			sb.append(pre);
		}
		return sb;
	}
	
	public static void main(String[] args){
		P38_CountAndSay pc = new P38_CountAndSay();
		for(int i=1; i<10; i++)
			System.out.println(pc.countAndSay(i));
	}
}
