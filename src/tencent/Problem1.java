package tencent;

import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        long m = sc.nextInt();

        System.out.println(m * m * (n / m / 2));
    }
}
