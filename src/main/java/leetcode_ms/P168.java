package leetcode_ms;

/**
 * Created by zjw on 2018/07/17 11:25
 * Description:
 */
public class P168 {

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while(n > 0) {
            builder.append((char)('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return builder.reverse().toString();
    }

}
