package solution;

import java.awt.print.Printable;

public class P9_PalindromeNumber {
	/*
	 * Negative number are not Palindrome Number!!!!
	 * special case: -2^31, 1999999999, 0, 105601, 1001, 101
	 * 1. calculate the bits number of x
	 */
	public boolean isPalindrome(int x) {
		int div_b = 1, div_a = 10, tempX = x, left = 0, right = 0;
		if (x < 0)
			return false;
		while( (tempX / div_b) >= 10) {
			div_b *= 10;
		}
		tempX = x;
		while(div_b >= div_a)
		{
			left = left * 10 + (tempX/div_b % 10);
			right=  right * 10 + ((tempX % div_a) / (div_a / 10));
			if(left != right)
				return false;
			div_b /= 10;
			div_a *= 10;
		}
		return true;
	}
	
	public boolean isPalindrome2(int x) {
		int newX = 0;
		if (x < 0 || (x!=0 &&x%10==0))
			return false;
		while(x > newX){
			newX = newX*10 + x%10;
			x /= 10;
		}
		return (x==newX) || (x==newX/10);
	}
	
	public static void main(String[] args) {
		int[] test_case = {0, -123, -101, -1001, -2442, 105601, 4224, 1999999999, -2147483648};
		int i = 0;
		P9_PalindromeNumber pp = new P9_PalindromeNumber();
		while(i < test_case.length){
			System.out.println(" " + test_case[i] + " " + pp.isPalindrome(test_case[i]));
			i++;
		}
	}
}
