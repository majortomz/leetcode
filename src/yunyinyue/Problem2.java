package yunyinyue;

import java.util.Scanner;

// 2018 problem2
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        if (k == 0) {
            System.out.println(n * n);
            return;
        }

        long res = 0;
        for (long y = k + 1; y <= n; y++) {
            res += (y - k) * (n / y);
            res += Math.max(0, n % y - k + 1);
        }

        System.out.println(res);
    }
}
