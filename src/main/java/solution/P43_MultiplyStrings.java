package solution;

import java.util.Arrays;

public class P43_MultiplyStrings {

	public String multiply(String num1, String num2) {
		String s1 = num1, s2 = num2;
		// record the result string
		StringBuilder sb = new StringBuilder();
		// let s1 be the string whose length is larger
		if(num1.length() < num2.length())
		{
			s1 = num2;
			s2 = num1;
		}
		int len1 = s1.length(), len2 = s2.length();
		// result[] 记录乘法的结果, v1[]记录s1对应的整数数组
		int result[] = new int[len1 + len2], v1[] = new int[len1];
		int c = 0, last_non_zero = 0;
		// 数字的低位保存在v1的低下标
		for(int i=0; i<s1.length(); i++)
			v1[s1.length()-i-1] = s1.charAt(i) - '0';
		// 模拟手工乘法，从s2的低下标开始乘
		for(int i=0; i<s2.length(); i++)
		{
			int k = s2.charAt(i) - '0', pos = s2.length()-i-1;
			for(int j=0; j<v1.length; j++)
				result[j+pos] += (v1[j] * k);
			System.out.println(Arrays.toString(result));
		}
		// 处理进位问题
		for(int i=0; i<result.length; i++)
		{
			c += result[i];
			result[i] = c % 10;
			c /= 10;
			// 记录最后一个非零位的下标
			last_non_zero = result[i]!=0?i:last_non_zero;
		}
		// 构造结果字符串
		for(int i=last_non_zero; i>=0; i--)
			sb.append(result[i]);
		return sb.toString();
	}
	
	public static void main(String[] args){
		P43_MultiplyStrings pm = new P43_MultiplyStrings();
		String num1 = "123", num2 = "456";
		System.out.println(pm.multiply(num1, num2));
	}
}
