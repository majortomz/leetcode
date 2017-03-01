package solution;


public class P7_ReverseInteger {
	/*
	 * 
	 */
	public int reverse(int x) {
		int neg_flag = x<0?-1:1, result = 0;
		while(x != 0) {
			long temp = (long)result * 10 + (x % 10) * neg_flag;
			if (temp < Integer.MIN_VALUE || temp > Integer.MAX_VALUE ){
				return 0;
			}
			result = result * 10 + (x % 10) * neg_flag;
			x /= 10;
		}
		return result * neg_flag;
	}
	
	//第二种解法，第一种解法依赖于long，现在不依赖于long
	public int reverse2(int x) {
		int result = 0;
		while(x != 0) {
			int temp = result * 10 + (x % 10);
			if (temp / 10 != result){
				return 0;
			}
			result = temp;
			x /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] test_case = {0, 123, -123, -1000000, 1999999999, 911111111};
		int i = 0;
		P7_ReverseInteger pr = new P7_ReverseInteger();
		while(i < test_case.length) {
			System.out.println(test_case[i]);
			System.out.println(pr.reverse2(test_case[i]));
			i++;
		}
	}
}
