package solution;

public class P8_StringToInteger {
	
	public int myAtoi(String str) {
		// flag : 1,positive; -1 negative
		int result = 0, i = 0, flag = 1;
		// eliminate the white spaces on the both sides of the string
		str = str.trim();
		// if the str is not empty, set the flag value and
		// return 0 if illegal character at the beginning
		if(!str.isEmpty())
		{
			if (str.charAt(i) == '+')
			{
				flag = 1;
				i++;
			}
			else if (str.charAt(i) == '-')
			{
				flag = -1;
				i++;
			}
			else if(!Character.isDigit(str.charAt(0)))
				return 0;
		}
		while(i < str.length() && Character.isDigit(str.charAt(i)))
		{
			int temp = result*10 + flag*(str.charAt(i) - '0');
			if(temp/10 == result)
			{
				result = temp;
				i++;
				continue;
			}
			if(flag == -1)
				return Integer.MIN_VALUE;
			else {
				return Integer.MAX_VALUE;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] test_case = {"   ", "1", "    55*", "   +5555", "-100000000000", "   *50"};
		int i = 0;
		P8_StringToInteger ps = new P8_StringToInteger();
		while(i < test_case.length) {
			System.out.println(" " + test_case[i] + " " + ps.myAtoi(test_case[i]));
			i++;
		}
	}
}
