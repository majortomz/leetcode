package solution;

import java.util.Stack;

public class P20_ValidParentheses {
	
	public boolean isValid(String s) {
		Stack<Character> sc = new Stack<Character>();
		int i = 0;
		while(i < s.length()) {
			char c = s.charAt(i);
			if(c == '(' || c=='{' || c=='[')
				sc.push(c);
			else {
				if (sc.isEmpty())
					return false;
				char top = sc.peek().charValue();
				if((c==')' && top=='(') || (c == ']' && top == '[')
						|| (c == '}' && top == '{'))
					sc.pop();
				else
					return false;
			}
			i++;
		}
		return sc.isEmpty();
	}
	
	
	public static void main(String[] args) {
		String[] test_case = {"{}{}", "{{[]}}", "", "[]]]"};
		int i = 0;
		P20_ValidParentheses pv = new P20_ValidParentheses();
		while(i < test_case.length) {
			System.out.println(test_case[i] + " " + pv.isValid(test_case[i]));
			i++;
		}
	}
}
