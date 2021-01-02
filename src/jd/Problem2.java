package jd;

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            long n = sc.nextLong();
            if(n % 2 == 0) {
                long tmp = n;
                while(n % 2 == 0) {
                    n /= 2;
                }
                System.out.println(tmp / n + " " + n);
            } else {
                System.out.println("No");
            }
        }
    }
}
