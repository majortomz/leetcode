package solution100_199;


public class P151_ReverseWordsInAString {

	public String reverseWords(String s){
		String[] words = s.trim().split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int i=words.length-1; i>=0; i--)
		{
			sb.append(words[i]);
			if(i != 0)	sb.append(" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String s = " ";
		P151_ReverseWordsInAString pr  = new P151_ReverseWordsInAString();
		System.out.println(pr.reverseWords(s));
	}
}
