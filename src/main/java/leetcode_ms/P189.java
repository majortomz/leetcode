package leetcode_ms;

/**
 * Created by zjw on 2018/08/05 10:54
 * Description:
 */
public class P189 {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }

        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int len = end - start + 1;
        for(int i = len / 2; i > 0; i--) {
            int tmp = nums[start + i - 1];
            nums[start + i - 1] = nums[end - i + 1];
            nums[end - i + 1] = tmp;
        }
    }

}
