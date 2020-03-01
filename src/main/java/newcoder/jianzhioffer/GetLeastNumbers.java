package newcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by zjw on 2018/03/07 17:25
 * Description:
 */
public class GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k <= 0 || k > input.length) return res;
        k--;
        helper(input, 0, input.length - 1, res, k);
        return res;
    }

    private void helper(int[] nums, int lo, int hi, ArrayList<Integer> res, int k) {
        if(lo > hi || k < lo) return;
        int p = partition(nums, lo, hi);
        if(k < p) {
            helper(nums, lo, p - 1, res, k);
        } else {
            for(int i = lo; i <= p; i++) {
                res.add(nums[i]);
            }
            helper(nums, p + 1, hi, res, k);
        }
    }


    private int partition(int[] nums, int lo, int hi) {
        int lt = lo - 1, x = nums[hi];
        for(int i = lo; i < hi; i++) {
            if(nums[i] < x) {
                lt++;
                int tmp = nums[lt];
                nums[lt] = nums[i];
                nums[i] = tmp;
            }
        }
        nums[hi] = nums[lt + 1];
        nums[lt + 1] = x;
        return lt + 1;
    }

    public static void main(String[] args) {
        GetLeastNumbers gn = new GetLeastNumbers();
        for(int i = 1; i <= 9; i++) {
            int[] test = {5, 4, 3, 10, 2, 64, 532, 5, 17, 99};
            System.out.println(gn.GetLeastNumbers_Solution(test, i));
        }
    }
}
