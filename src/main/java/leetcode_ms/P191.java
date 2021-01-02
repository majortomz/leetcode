package leetcode_ms;

/**
 * Created by zjw on 2018/08/05 10:09
 * Description:
 */
public class P191 {

    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0; i <= 31; i++) {
            if(((1 << i) & n) != 0) {
                res++;
            }
        }
        return res;
    }

}
