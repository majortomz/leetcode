package solution500_599;

import java.util.Arrays;

/**
 * Created by zjw on 2017/8/4.
 */
public class P516_LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        char[] sa = s.toCharArray();
        char[] sb = new char[sa.length];
        for(int i = 0; i < sa.length; i++) {
            sb[i] = sa[sa.length - 1 - i];
        }

        return longestSubseqLength(sa, sb);
    }

    public int longestSubseqLength(char[] sa, char[] sb) {
        int[][] mat = new int[sa.length][sa.length];

        for(int i = 0; i < sa.length; i++) {
            for(int j = 0; j < sb.length; j++) {
                if(sa[i] == sb[j]) {
                    mat[i][j] = (i == 0 || j == 0 ? 0:mat[i-1][j-1]) + 1;
                }
                else {
                    int left = (j == 0 ? 0 : mat[i][j-1]);
                    int up = (i == 0 ? 0 : mat[i-1][j]);
                    mat[i][j] = Math.max(left, up);
                }
            }
        }
        return mat[sa.length-1][sb.length-1];
    }

}
