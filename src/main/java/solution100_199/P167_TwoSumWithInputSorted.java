package solution100_199;

public class P167_TwoSumWithInputSorted {
	
	public int[] twoSum(int[] numbers, int target) {
		int lt = 0, rt = 0;
		for(int i=0; i<numbers.length-1; i++)
		{
			int k = target - numbers[i];
			if(k < numbers[i])
				continue;
			rt = binary_search(numbers, i+1, k);
			if(rt != -1)
			{
				lt = i+1;
				rt += 1;
				break;
			}
		}
		int[] result = {lt, rt};
		return result;
	}
	
	public int binary_search(int[] nums, int start, int k){
		int left = start, right = nums.length-1, mid;
		while(left<=right)
		{
			mid = (left+right)/2;
			if(nums[mid] == k)
				return mid;
			else if(nums[mid] < k)
			{
				left = mid+1;
			}
			else{
				right = mid -1;
			}
		}
		return -1;
	}
}
