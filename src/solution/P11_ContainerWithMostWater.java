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
	
	
}
