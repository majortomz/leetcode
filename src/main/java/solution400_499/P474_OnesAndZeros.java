package solution400_499;

/**
 * Created by zjw on 2017/8/30.
 */
public class P474_OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] nums = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++) {
            for(int j = 0; j < strs[i].length(); j++) {
                if(strs[i].charAt(j) == '0')
                    nums[i][0]++;
                else
                    nums[i][1]++;
            }
        }
        return helper(nums, m, n, 0, 0);
    }

    public int helper(int[][] nums, int m, int n, int pos, int count) {
        if(m == 0 && n == 0)    return count;
        int res = 0;
        for(int i = pos; i < nums.length; i++) {
            int nm = m - nums[i][0], nn = n - nums[i][1];
            if(nm >= 0 && nn >= 0)
                res = Math.max(res, helper(nums, nm, nn,  i + 1, count + 1));
        }
        return res;
    }

}
