package zhaohang;

import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        while(sc.hasNext()) {
            sum -= sc.nextInt();
        }
        System.out.println(sum);
    }

}
