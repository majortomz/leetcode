package newcoder.wangyi.code2018;

import java.util.Scanner;

/**
 * Created by zjw on 2018/03/26 20:04
 * Description:
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            if(n % 2 == 0) {
                sb.insert(0, "2");
                n -= 2;
            } else {
                sb.insert(0, "1");
                n -= 1;
            }
            n /= 2;
        }
        System.out.println(sb.toString());
    }

}
