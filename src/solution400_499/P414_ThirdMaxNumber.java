package solution400_499;

/**
 * Created by zjw on 2017/5/19.
 */
public class P414_ThirdMaxNumber {

    // using Integer instead of primitive data type is more concise...
    public int thirdMax(int[] nums) {
        long max, second, third;
        max = third = second = Long.MIN_VALUE;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] == max || nums[i] == second || nums[i] == third)
                continue;
            if(nums[i] > max) {
                third = second;
                second = max;
                max = nums[i];
            }
            else if(nums[i] > second) {
                third = second;
                second = nums[i];
            }
            else if(nums[i] > third) {
                third = nums[i];
            }
        }
        if(third == Long.MIN_VALUE)
            return (int)max;
        else
            return (int)third;
    }
}
