package test;

import java.util.Scanner;

/**
 * Created by zjw on 2018/08/22 19:43
 * Description:
 */
public class P3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        int max = 0;
        char[] words = s.toCharArray();

        boolean[][] dp = new boolean[n][n];
        for(int i = 1; i < n; i++) {
            if(words[i] == ')' && words[i - 1] == '(') {
                max = 2;
                dp[i - 1][i] = true;
            }
        }

        for(int len = 4; len <= n; len += 2) {
            for(int i = n - len; i >= 0; i--) {
                int j = i + len - 1;
                if(dp[i + 1][j - 1] && words[i] == '(' && words[j] == ')') {
                    dp[i][j] = true;
                    max = len;
                } else {
                    for(int k = i + 1; k < j; k++) {
                        if(dp[i][k] && dp[k + 1][j]) {
                            dp[i][j] = true;
                            max = len;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

}
