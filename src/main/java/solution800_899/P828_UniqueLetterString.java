package solution800_899;

import java.util.Arrays;

/**
 * Created by zjw on 2018/05/06 10:28
 * Description:
 */
public class P828_UniqueLetterString {

    private static final int MOD = 1_000_000_007;

    // TLE
    public static int uniqueLetterString(String S) {
        int[][] flags = new int[S.length()][26];
        int[] map = new int[S.length()];

        char[] words = S.toCharArray();
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            flags[i][words[i] - 'A'] = 1;
            map[i] = 1;
            count++;
        }
        System.out.println(count);

        for (int len = 2; len <= S.length(); len++) {
            for (int i = S.length() - len; i >= 0; i--) {
                int j = i + len - 1;
                if (flags[i][words[j] - 'A'] == 1) {
                    map[i] -= 1;
                } else if (flags[i][words[j] - 'A'] == 0) {
                    map[i] += 1;
                }
                flags[i][words[j] - 'A'] += 1;
                if (count >= MOD) {
                    count %= MOD;
                }
                count += map[i];
            }
        }
        return count % MOD;
    }

    // O(n) solution, from leetcode discussion
    public static int uniqueLetterString2(String S) {
        if(S == null || S.length() == 0) {
            return 0;
        }
        int[][] index= new int[26][2];
        int res = 0;

        for(int[] item: index) {
            Arrays.fill(item, -1);
        }

        for(int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % MOD) % MOD;
            index[c][0] = index[c][1];
            index[c][1] = i;
        }

        for(int[] item: index) {
            res = (res + (S.length() - item[1]) * (item[1] - item[0]) % MOD) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("AAA"));
    }
}
