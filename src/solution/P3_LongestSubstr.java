package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zjw on 2018/03/20 20:32
 * Description:
 */
public class P3_LongestSubstr {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)   return 0;
        int[] map = new int[256];
        char[] words = s.toCharArray();
        int start = 0, max = 1;
        Arrays.fill(map, 0, map.length, -1);
        map[words[0]] = 0;
        for(int i = 1; i < words.length; i++) {
            int len = i - Math.max(map[words[i]] + 1, start) + 1;
            max = Math.max(len, max);
            start = Math.max(map[words[i]] + 1, start);
            map[words[i]] = i;
        }
        return max;
    }
}
