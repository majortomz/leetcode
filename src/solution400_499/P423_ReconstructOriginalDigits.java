package solution400_499;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/01/28 16:00
 * Description:
 */
public class P423_ReconstructOriginalDigits {

    public String originalDigits(String s) {StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0) {
            return sb.toString();
        }

        int[] count = new int[10];
        int[] map = new int[26];

        char[] keys = {'z', 'w', 'u', 'r', 'x', 's', 'g', 'o', 'v', 'i'};
        int[] digits = {0, 2, 4, 3, 6, 7, 8, 1, 5, 9};
        String[] engs = {"zero", "two", "four", "three", "six", "seven", "eight", "one", "five", "nine"};

        for(char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for(int i = 0; i < keys.length; i++) {
            int min = map[keys[i] - 'a'];
            for(char c : engs[i].toCharArray()) {
                min = Math.min(min, map[c - 'a']);
            }
            for(char c : engs[i].toCharArray()) {
                map[c - 'a'] -= min;
            }
            count[digits[i]] = min;
        }
        for(int i = 0; i < count.length; i++) {
            for(int j = 1; j <= count[i]; j++)
                sb.append(i);
        }
        return sb.toString();
    }

}
