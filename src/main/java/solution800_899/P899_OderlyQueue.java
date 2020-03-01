package solution800_899;

import java.util.Arrays;

/**
 * Created by zjw on 2018/09/03 20:49
 * Description:
 */
public class P899_OderlyQueue {

    public String orderlyQueue(String S, int K) {
        if(K > 1) {
            char[] words = S.toCharArray();
            Arrays.sort(words);
            return new String(words);
        } else {
            String res = S;
            for(int i = 1; i < S.length(); i++) {
                String r = S.substring(i, S.length()) + S.substring(0, i);
                if(res.compareTo(r) > 0) {
                    res = r;
                }
            }
            return res;
        }

    }

}
