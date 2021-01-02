package solution;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class P39_CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rList = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
    	List<Integer> la = new LinkedList<Integer>();
    	cal(rList, la, 0, 0, candidates, target);
        return rList;
    }
	
	private void cal(List<List<Integer>> rl, List<Integer> current, int max, int sum, int[] can, int target)
    {
    	for(int i = 0; i<can.length; i++)
    	{
    		// in case of duplicates
    		if(max > can[i])
    			continue;
    		int sum_new = sum + can[i];
    		// larger than target, no need to calculate
    		if(sum_new > target)
    			continue;
    		// equal to the target, add to result list: rl
    		else if(sum_new == target)
    		{
    			List<Integer> result = new LinkedList<Integer>();
    			result.addAll(current);
    			result.add(can[i]);
    			rl.add(result);
    		}
    		// smaller than the target, need to continue to find answer
    		else
    		{
    			List<Integer> result = new LinkedList<Integer>();
    			result.addAll(current);
    			result.add(can[i]);
    			cal(rl, result, can[i], sum_new, can, target);
    		}
    	}
    }
	
	public static void main(String[] args) {
		int[] can = {2, 3, 6, 7};
		int target = 6;
		P39_CombinationSum pc = new P39_CombinationSum();
		System.out.println(pc.combinationSum(can, target).toString());
	}
}
