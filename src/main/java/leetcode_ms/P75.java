package leetcode_ms;

/**
 * Created by zjw on 2018/08/03 17:34
 * Description:
 */
public class P75 {

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int zero = 0, two = nums.length - 1;
        for(int i = 0; i <= two; i++) {
            if(nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
            } else if(nums[i] == 2){
                while(two > i && nums[two] == 2) {
                    two--;
                }
                swap(nums, i, two);
                two--;
                if(nums[i] == 0) {
                    swap(nums, i, zero);
                    zero++;
                }
            }
        }
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
