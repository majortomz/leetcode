package solution300_399;

import java.util.Arrays;

/**
 * Created by zjw on 2018/01/24 13:18
 * Description:
 */
public class P387_FindUniqueChar {

    public int firstUniqChar(String s) {
        int[] pos = new int[256];
        char[] chars = s.toCharArray();
        Arrays.fill(pos, -1);
        for(int i = 0; i < chars.length; i++) {
            if(pos[chars[i]] == -1) {
                pos[chars[i]] = i;
            } else if(pos[chars[i]] >= 0) {
                pos[chars[i]] = -2;
            }
        }
        int min = chars.length;
        for(int item : pos) {
            if(item >= 0) {
                min = Math.min(min, item);
            }
        }
        return min == chars.length ? -1 : min;
    }

}
