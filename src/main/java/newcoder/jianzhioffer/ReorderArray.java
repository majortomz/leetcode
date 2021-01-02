package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/02 14:05
 * Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *          所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReorderArray {

    public void reOrderArray(int [] array) {
        int[] helper = new int[array.length];
        int odd = 0, even = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                helper[even++] = array[i];
            } else {
                array[odd++] = array[i];
            }
        }
        for(int i = 0; i < even; i++) {
            array[odd++] = helper[i];
        }
    }

}
