package solution;

public class P32_LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		int max = 0, last = -1;
		int[][] pos = new int[s.length()][2];
		for(int i=0; i<s.length(); )
		{
			int m = i, n = i+1, len = 0;
			// 当前位置向两侧找到最长的合法串
			while(m>=0 && n<s.length() && s.charAt(m)=='(' && s.charAt(n)==')')
			{
				m--;
				n++;
				len+=2;
			}
			if(len == 0)
			{
				i = n;
				continue;
			}
			// 如果起始位置和上一个合法串的终止位置相邻，则更新上个合法串的终止位置
//			System.out.println(m + " " + n);
			if(last != -1 && m == pos[last][1])
			{
				len += (pos[last][1] - pos[last][0] + 1);
				pos[last][1] = n-1;
			}
			else {
				last++;
				pos[last][0] = m+1;
				pos[last][1] = n-1;
			}
			m = pos[last][0] - 1;
			n = pos[last][1] + 1;
			while(m>=0 && n<s.length() && s.charAt(m)=='(' && s.charAt(n)==')')
			{
				m--;
				n++;
				len+=2;
			}
			pos[last][0] = m+1;
			pos[last][1] = n-1;
			// 更新最后一个合法串的位置，更新max
			if(last>0 && pos[last-1][1] + 1 == pos[last][0])
			{
				len += (pos[last - 1][1] - pos[last - 1][0] + 1);
				pos[last - 1][1] = pos[last][1];
				last--;
			}
			max = len>max?len:max;
			i = n;
		}
		return max;
	}
	
	// 动态规划，类似于解决矩阵链乘的方法
	public int longestValidParentheses2(String s) {
		int[][] mat = new int[s.length()][s.length()];
		int max = 0;
		for(int len=2; len<=s.length(); len+=2)
		{
			for(int j=0; j<=s.length()-len; j++)
			{
				int start = j, end = j+len-1;
				if(s.charAt(start) == '(' && s.charAt(end) == ')' 
						&& mat[start+1][end-1] == len-2)
				{	
					mat[start][end] = len;
					max = len;
				}
				for(int k=2; k<len; k+=2)
				{
					if(mat[j][j+k-1] + mat[j+k][end] == len)
					{	
						mat[start][end] = len;
						max = len;
						break;
					}
				}
			}
		}
		return max;
	}
	
	// Solution 3
	public int longestValidParentheses3(String s) {
		int val[] = new int[s.length()], max = 0;
		int count = 0; // the number of '('
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i) == '(')  count++;
			if(s.charAt(i) == ')' && count>0)
			{
				count--;
				val[i] += 2 + val[i-1];
				if(i- val[i] >= 0)  val[i] += val[i-val[i]];
			}
			if(val[i] > max)	max = val[i];
		}
		return max;
	}
	
	//
	public static void main(String[] args){
		P32_LongestValidParentheses pl = new P32_LongestValidParentheses();
		System.out.println(pl.longestValidParentheses2("((())())(()))(()()(()(()))(()((((()))))))((()())()))()()(()(((((()()()())))()())(()()))((((((())))((()))()()))))(()))())))()))()())((()()))))(()(((((())))))()((()(()(())((((())(())((()()(()())))())(()(())()()))())(()()()))()(((()())(((()()())))(((()()()))(()()))()))()))))))())()()((()(())(()))()((()()()((())))()(((()())(()))())())))(((()))))())))()(())))()())))())()((()))((()))()))(((())((()()()(()((()((())))((()()))())(()()(()))))())((())))(()))()))))))()(()))())(()())))))(()))((())(()((())(((((()()()(()()())))(()())()((()(()()))(()(())((()((()))))))))(()(())()())()(()(()(()))()()()(()()())))(())(()((((()()))())))(())((()(())())))))())()()))(((())))())((()(()))(()()))((())(())))))(()(()((()((()()))))))(()()()(()()()(()(())()))()))(((()(())()())(()))())))(((()))())(()((()))(()((()()()(())()(()())()(())(()(()((((())()))(((()()(((()())(()()()(())()())())(()(()()((()))))()(()))))(((())))()()))(()))((()))))()()))))((((()(())()()()((()))((()))())())(()((()()())))))))()))(((()))))))(()())))(((()))((()))())))(((()(((())))())(()))))(((()(((((((((((((())(((()))((((())())()))())((((())(((())))())(((()))))()())()(())())(()))))()))()()()))(((((())()()((()))())(()))()()(()()))(())(()()))()))))(((())))))((()()(()()()()((())((((())())))))((((((()((()((())())(()((()))(()())())())(()(())(())(()((())((())))(())())))(()()())((((()))))((()(())(()(()())))))))))((()())()()))((()(((()((()))(((((()()()()()(()(()((()(()))(()(()((()()))))()(()()((((((()((()())()))((())()()(((((()(()))))()()((()())((()())()(())((()))()()(()))"
));
	}
}
