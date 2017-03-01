package solution400_499;

public class P477_TotalHammingDistance {
	public int totalHammingDistance(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++)
				result += hammingDistance(nums[i], nums[j]);
		}
		return result;
	}

	public int totalHammingDistance2(int[] nums){
		int result = 0;
		for(int i=0; i<32; i++)
		{
			int one_count = 0;   //record the number of 1 bit value
			for(int j=0; j<nums.length; j++){
				int last_bit = nums[j]>>i;
				one_count += (last_bit & 1);
			}
			result += (nums.length - one_count)*one_count;
		}
		return result;
	}
	
	public int hammingDistance(int x, int y) {
		int dis = 0;
		String s = Integer.toBinaryString(x ^ y);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				dis += 1;
		}
		return dis;
	}
	
	public static void main(String[] args){
		int[] test = {4, 14, 2};
		P477_TotalHammingDistance pt = new P477_TotalHammingDistance();
		System.out.println(pt.totalHammingDistance2(test));
	}
	
}
