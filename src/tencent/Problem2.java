package tencent;

import java.util.Scanner;

public class Problem2 {

    static int[][][] dp;
    static int lenA, lenB;
    static int mod = 1000000007;

    public static int helper(int k, int countA, int countB) {
        if(k < 0 || countA == 0 && countB == 0)  return 0;
        if(k == 0) {
            return 1;
        }
        if(countA == 0) {
            dp[k][countA][countB] = k % lenB == 0 && k / lenB <= countB ? 1 : 0;
        }
        if(countB == 0) {
            dp[k][countA][countB] = k % lenA == 0 && k / lenA <= countA ? 1 : 0;
        }

        if(dp[k][countA][countB] > 0)   return dp[k][countA][countB];
        dp[k][countA][countB] = (helper(k - lenA,  countA - 1, countB)
                + helper(k - lenB,  countA, countB - 1) ) % mod;
        return dp[k][countA][countB];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        lenA = sc.nextInt();
        int countA = sc.nextInt();
        lenB = sc.nextInt();
        int countB = sc.nextInt();
        dp = new int[k + 1][countA + 1][countB + 1];
        System.out.println(helper(k, countA, countB));
    }
}
