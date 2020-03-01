package solution;

public class P11_ContainerWithMostWater {
	
	// Solution 1: Brute Force, TLE
	public int maxArea(int[] height) {
		int result = 0, tmp = 0;
		for(int i=0; i<height.length-1; i++)
		{
			for(int j=i+1; j<height.length; j++)
			{
				tmp = Math.min(height[i], height[j])*(j-i);
				result = tmp>result?tmp:result;
			}
		}
		return result;
	}

	// From leetcode discussion
	public int maxArea2(int[] height) {
		int left = 0, right = height.length - 1;
		int res = 0;
		while(left < right) {
			res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
			if(height[left] < height[right])
				left++;
			else
				right--;
		}
		return res;
	}
	
}
