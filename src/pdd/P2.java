package pdd;

import java.util.Scanner;

/**
 * Created by zjw on 2018/08/05 19:19
 * Description:
 */
public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();
        int res = 0;
        for(int i = num.length() - 1; i >= 1; i--) {
            String a = num.substring(0, i), b = num.substring(i, num.length());
            int countA = count(a), countB = count(b);
            res += (countA * countB);
        }

        System.out.println(res);
    }

    public static int count(String num) {
        int res = 0, n = num.length();

        if(num.length() > 1 && num.charAt(n - 1) != '0') {
            if(num.charAt(0) == '0') {
                res = 1;
            } else {
                res = n - 1;
            }
        }

        if(num.length() == 1 || num.charAt(0) != '0') {
            res++;
        }
        return res;
    }

}
