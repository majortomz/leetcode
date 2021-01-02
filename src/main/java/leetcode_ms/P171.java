package leetcode_ms;

/**
 * Created by zjw on 2018/07/17 11:19
 * Description:
 */
public class P171 {

    public int titleToNumber(String s) {
        int res = 0;
        for(char c: s.toCharArray()) {
            res = res * 26 + (c - 'A' + 1);
        }
        return res;
    }

}
