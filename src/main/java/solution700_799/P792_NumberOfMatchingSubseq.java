package solution700_799;

import java.util.Arrays;

/**
 * Created by zjw on 2018/03/04 10:43
 * Description:
 */
public class P792_NumberOfMatchingSubseq {

    public int numMatchingSubseq(String S, String[] words) {
        if(S == null || words == null || S.length() == 0)   return 0;
        char arr[] = S.toCharArray();
        int[][] dp = new int[S.length() + 1][26];
        Arrays.fill(dp[dp.length - 1], -1);
        for(int i = arr.length - 1; i >= 0; i--) {
            dp[i] = Arrays.copyOf(dp[i + 1], dp[i + 1].length);
            dp[i][arr[i] - 'a'] = i;
        }
        int count = 0;
        for(String word : words) {
            int next = 0;
//            System.out.println(word);
            for(char c : word.toCharArray()) {
                int tmp = dp[next][c - 'a'];
//                System.out.println(tmp);
                if(tmp == -1) {
                    next = tmp;
                    break;
                } else {
                    next = tmp == next ? next + 1 : tmp + 1;
                }
            }
            if(next != -1) count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        P792_NumberOfMatchingSubseq nm = new P792_NumberOfMatchingSubseq();
        nm.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
    }

}
