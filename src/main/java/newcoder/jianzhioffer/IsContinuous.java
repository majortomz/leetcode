package newcoder.jianzhioffer;

import java.util.Arrays;

/**
 * Created by zjw on 2018/03/08 13:48
 * Description: 扑克牌顺子
 */
public class IsContinuous {

    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length != 5)    return false;
        Arrays.sort(numbers);
        int i = 0;
        int zeros = 0, gap = 0;
        while(i < numbers.length && numbers[i] == 0) {
            zeros++;
            i++;
        }
        i++;
        while(i < numbers.length) {
            if(numbers[i] == numbers[i - 1])    return false;
            gap += (numbers[i] - numbers[i - 1] - 1);
            i++;
        }
        return zeros >= gap;
    }
}
