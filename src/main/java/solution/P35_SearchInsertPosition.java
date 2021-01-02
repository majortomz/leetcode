package solution;

public class P35_SearchInsertPosition {

	// Solution 1: traverse
	public int searchInsert(int[] nums, int target) {
		int pos = 0;
		for(pos=0; pos<nums.length; pos++)
		{
			if(target <= nums[pos])	break;
		}
		return pos;
	}
	// Solution 2: binary search
	public int searchInsert2(int[] nums, int target) {
		int low = 0, high = nums.length - 1, mid;
		while(low <= high)
		{
			mid = (low + high) / 2;
			if(target > nums[mid])
				low = mid + 1;
			else
				high = mid -1;
		}
		return low;
	}
}
