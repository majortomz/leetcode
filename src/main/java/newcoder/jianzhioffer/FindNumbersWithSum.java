package newcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by zjw on 2018/03/08 12:50
 * Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int small = 0, big = array.length - 1;
        while(small < big) {
            int tmp = array[small] + array[big];
            if(tmp == sum) {
                arr.add(array[small]);
                arr.add(array[big]);
                break;
            } else if(tmp > sum) {
                big--;
            } else {
                small++;
            }
        }
        return arr;
    }
}
