package solution;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class P17_LetterCombinationOfPhoneNumber {
	
	public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        String[][] sa = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
        		{"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, 
        		{"t", "u", "v"}, {"w", "x", "y", "z"}};
        if(digits.isEmpty() || digits.indexOf('0') != -1 || digits.indexOf('1')!=-1)
        	return result;
        result.add("");
        for(int i=0; i<digits.length(); i++)
        {
        	int k = digits.charAt(i) - '2';
        	List<String> temp = new ArrayList<String>();
        	for(String sb : result)
        		for(String sc : sa[k]){
        			temp.add(sb + sc);
        		}
        	result = temp;
        }
        return result;
    }
	
	public static void main(String[] args){
		String[] test_case = {"0", "91", "23"};
		P17_LetterCombinationOfPhoneNumber pl = new P17_LetterCombinationOfPhoneNumber();
		for (String s: test_case){
			System.out.println(s + " " + pl.letterCombinations(s));
		}
	}
}
