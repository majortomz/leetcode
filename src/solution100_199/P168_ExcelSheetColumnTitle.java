package solution100_199;

/**
 * Created by zjw on 2017/9/28.
 */
public class P168_ExcelSheetColumnTitle {

    /**
     * 将题目转化为求解10进制转26进制，区别在于26进制从1开始
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if(n <= 0)  return sb.toString();

        // calculate dictionary
        char[] dict = new char[26];
        for(int i = 0; i < dict.length; i++) {
            dict[i] = (char)('A' + i);
        }
        while(n > 0) {
            // 计算当前位在数组中的下标
            int mod = (n - 1) % 26;
            sb.insert(0, dict[mod]);
            // 不能直接 n /= 26; 应该用 n = (n - 1) / 26
            n = (n - mod) / 26;
        }
        return sb.toString();
    }

}
