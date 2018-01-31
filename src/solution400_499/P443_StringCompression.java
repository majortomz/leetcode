package solution400_499;

import java.util.Arrays;

/**
 * Created by zjw on 2018/01/31 13:51
 * Description:
 */
public class P443_StringCompression {

    public int compress(char[] chars) {
        if(chars == null || chars.length == 0)
            return 0;
        int len = 0, count = 0;
        for(int i = 0; i < chars.length; i++) {
            count++;
            if(i + 1 < chars.length && chars[i] == chars[i + 1]) {
                continue;
            }
            chars[len++] = chars[i];
            if(count > 1) {
                int k = (int)Math.pow(10, (int)Math.log10(count));
                while(k > 0) {
                    chars[len++] = (char)(48 + count / k);
                    count %= k;
                    k /= 10;
                }
            }
            count = 0;
        }
        return len;
    }

}
