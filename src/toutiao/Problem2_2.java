package toutiao;

// package toutiao;
import java.util.Scanner;


public class Problem2_2 {


    private static int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n1], b = new int[n2];
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }

        int res = 0;
        res += combination(a, 0, m);
        for (int i = 0; i < n2 && b[i] <= m; i++) {
            res += (b[i] == m ? 1 : combination(a, 0, m - b[i]));
            res %= MOD;
        }
        res %= MOD;
        System.out.println(res);
    }

    private static int combination(int[] a, int start, int target) {
        if (target == 0) return 1;
        if (start >= a.length || target < 0) return 0;

        int res = combination(a, start + 1, target);
        while (target >= a[start]) {
            target -= a[start];
            res += combination(a, start + 1, target);
            res %= MOD;
        }
        res %= MOD;
        return res;
    }

}
