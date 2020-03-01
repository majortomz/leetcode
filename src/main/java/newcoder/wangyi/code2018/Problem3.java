package newcoder.wangyi.code2018;

import java.util.Scanner;

/**
 * Created by zjw on 2018/03/26 20:20
 * Description:
 */
public class Problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int prev = s.charAt(0);
        int count = 1;
        for(char c : s.toCharArray()) {
            if(c != prev) {
                prev = c;
                count++;
            }
        }
        System.out.printf("%.2f", 1.0 * s.length() / count);
    }
}
