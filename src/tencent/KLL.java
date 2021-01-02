package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class KLL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i]  = sc.nextInt();
        }

        Arrays.sort(a);
        int res = 0;
        boolean flag = true;
        for(int i = n - 1; i >= 0; i--) {
            res += flag ? a[i] : -a[i];
            flag = !flag;
        }
        System.out.println(res);
    }
}
