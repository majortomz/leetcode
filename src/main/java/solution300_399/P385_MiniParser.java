package solution300_399;

import java.util.Stack;


// This is the interface that allows for creating nested lists.
class NestedInteger {
	
	public NestedInteger(){}
	
	public NestedInteger(int value){}
	

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value){}

	// Set this NestedInteger to hold a nested list and adds a nested
	// integer to it.
	public void add(NestedInteger ni){}
}

public class P385_MiniParser {

	public NestedInteger deserialize(String s) {
		Stack<NestedInteger> stack = new Stack<NestedInteger>();
		NestedInteger cur = null;
		int val = 0, flag = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				// 遇到[，则将当前列表入栈，新建一个列表
				stack.push(cur);
				cur = new NestedInteger();
				continue;
			} else if (s.charAt(i) == ']') {
				// 遇到]
				NestedInteger tmp = stack.pop();
				if (tmp == null)
					break;
				else {
					tmp.add(cur);
					cur = tmp;
				}
				continue;
			} else if (s.charAt(i) == ',')
				continue;
			// 处理是数字的情况
			val = 0;
			flag = 1;
			if (s.charAt(i) == '-') {
				// 如果有负号
				flag = -1;
				i++;
			}
			while (i < s.length() && Character.isDigit(s.charAt(i))) {
				val = val * 10 + s.charAt(i) - '0';
				i++;
			}
			val *= flag;
			NestedInteger ni = new NestedInteger(val);
			if (cur != null)
				cur.add(ni);
			else
				cur = ni;
			i--;
		}
		return cur;
	}

	
	
}
