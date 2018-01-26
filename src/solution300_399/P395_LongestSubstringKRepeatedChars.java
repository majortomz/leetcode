package solution300_399;

/**
 * Created by zjw on 2018/01/25 15:07
 * Description:
 */
public class P395_LongestSubstringKRepeatedChars {

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] counter = new int[26];
            int total = 0, larger = 0;
            for (int j = i; j >= 0; j--) {
                int index = chars[j] - 'a';
                counter[index]++;
                if (counter[index] == k) larger++;
                if (counter[index] == 1) total++;
                if (larger == total) {
                    max = Math.max(max, i - j + 1);
                }
            }
        }
        return max;
    }


    class Solution2 {
        // solution2, idea from leetcode discussion
        // key idea: find the point where we need to split the string
        public int longestSubstring(String s, int k) {
            if (s == null || s.length() < k) {
                return 0;
            }
            int[] counter = new int[26];
            char[] chars = s.toCharArray();
            for (char word : chars) {
                counter[word - 'a']++;
            }

            int max = 0, lastIndex = 0;
            // i <= chars.length 用来处理s最后一位字符不是split point的情况
            for (int i = 0; i <= chars.length && lastIndex < chars.length; i++) {
                if(i == chars.length && lastIndex == 0) {
                    break;
                } else if (i == chars.length || counter[chars[i] - 'a'] < k) {
                    max = Math.max(max, longestSubstring(s.substring(lastIndex, i), k));
                    lastIndex = i + 1;
                }
            }
            return lastIndex == 0 ? s.length() : max;
        }

    }
}
