package solution;

public class P26_RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicates(int[] nums) {
        if(nums.length<=1)
        	return nums.length;
        int len_new = 1;
        for(int i=1; i<nums.length; i++)
        {
        	if(nums[i] > nums[len_new-1])
        	{
        		len_new++;
        		if(i == len_new-1)
        			continue;
        		int t = nums[len_new-1];
        		nums[len_new-1] = nums[i];
        		nums[i] = t;
        	}
        }
        return len_new;
    }
	
}
