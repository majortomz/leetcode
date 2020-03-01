package newcoder.jianzhioffer;

import java.util.ArrayList;

/**
 * Created by zjw on 2018/03/08 12:27
 * Description: 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int small = 1, big = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(small <= sum / 2) {
            int tmp = (small + big) * (big - small + 1) / 2;
            if(tmp == sum) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = small; i <= big; i++) {
                    list.add(i);
                }
                small++;
                res.add(list);
            } else if(tmp < sum) {
                big++;
            } else {
                small++;
            }
        }
        return res;
    }

}
