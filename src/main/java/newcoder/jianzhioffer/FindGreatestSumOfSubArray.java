package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/07 19:16
 * Description:
 */
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0)    return 0;
        int max = array[0], sum = array[0];
        for(int i = 1; i < array.length; i++) {
            if(sum >= 0) {
                sum += array[i];
                max = Math.max(max, sum);
            } else {
                sum = array[i];
                max = Math.max(max, array[i]);
            }
        }
        return max;
    }

}
