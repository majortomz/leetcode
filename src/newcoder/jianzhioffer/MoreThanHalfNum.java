package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/07 17:11
 * Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。如果不存在则输出0。
 */
public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int[] array) {
        if(array.length == 0)   return 0;
        int num = array[0], count = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] == array[i - 1]) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                num = array[i];
                count = 1;
            }
        }
        // verify
        count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == num) count++;
        }
        return count * 2 > array.length ? num : 0;
    }

}
