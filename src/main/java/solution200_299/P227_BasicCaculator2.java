package solution200_299;

import java.util.Stack;

import javax.xml.stream.events.Characters;

public class P227_BasicCaculator2 {

	public int calculate(String s) {
		Stack<Integer> num = new Stack<Integer>();
		Stack<Character> symbol = new Stack<Character>();
		for(int i=0; i<s.length(); i++)
		{
			// 如果是空格，则继续
			if(s.charAt(i) == ' ')
				continue;
			// 符号则压栈
			else if(isSymbol(s.charAt(i)))
			{
				symbol.push(s.charAt(i));
				continue;
			}
			// 解析数字
			int a = 0, b;
			while(i<s.length() && Character.isDigit(s.charAt(i)))
			{
				a = a*10 + s.charAt(i) - '0';
				i++;
			}
			// 找到下一个符号的位置
			while(i<s.length() && s.charAt(i) == ' ')
				i++;
			// 不断获取栈顶符号，比较和下一个符号的优先级，如果>=则开始计算
			while(!num.isEmpty() && !symbol.isEmpty())
			{
				if(i >= s.length() || 
						getPriority(symbol.peek()) >= getPriority(s.charAt(i)))
				{
					b = num.pop();
					a = calValue(b, a, symbol.peek());
					symbol.pop();
				}
				else
					break;
			}
			num.push(a);
			i--;
		}
		if(symbol.isEmpty())
			return num.peek();
		else
		{
		    int a = num.pop();
		    int b = num.pop();
		    return calValue(b, a, symbol.peek());
		}
	}

	public int calValue(int a, int b, char symbol)
	{
		switch(symbol) {
		case '+': 
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			return a/b;
		default:
			return 0;
		}
	}
	
	public boolean isSymbol(char c){
		switch(c){
		case '+':
		case '-':
		case '*':
		case '/':
			return true;
		default: 
			return false;
		}
	}
	
	public int getPriority(char c) {
		int p = -1;
		switch (c) {
			case '+':
			case '-':
				p = 1;
				break;
			case '*':
			case '/':
				p = 2;
				break;
			default:
				p = 0;
		}
		return p;
	}
	
	public int calculate2(String s){
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char symbol = '+';
		for(int i=0; i<s.length(); i++)
		{
			if(Character.isDigit(s.charAt(i)))
			{
				num = num*10 + s.charAt(i) - '0';
			}
			if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i==s.length()-1)
			{
				switch(symbol)
				{
				case '+':
					stack.push(num);	break;
				case '-':
					stack.push(-num);	break;
				case '*':
					stack.push(stack.pop()*num); break;
				case '/':
					stack.push(stack.pop()/num); break;
				}
				symbol = s.charAt(i);
				num = 0;
			}
		}
		num = 0;
		while(!stack.isEmpty())
			num += stack.pop();
		return num;
	}
	
	/*Test Case
		"0"
		"2"
		" 3+5 / 2 "
		"3+2*2"
		"1*2-3/4+5*6-7*8+9/10"
	*/
	public static void main(String[] args){
		P227_BasicCaculator2 pb = new P227_BasicCaculator2();
		String s = " 3+5 / 2 ";
		System.out.println(pb.calculate2(s));
	}
}
