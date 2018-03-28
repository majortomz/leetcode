package newcoder.wangyi.code2018;

import java.util.Scanner;

/**
 * Created by zjw on 2018/03/26 20:17
 * Description:
 */
public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0, k = n;
        while(k > 0) {
            m = m * 10 + (k % 10);
            k /= 10;
        }
        System.out.println(m + n);
    }

}
