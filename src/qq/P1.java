package qq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zjw on 2018/09/16 11:09
 * Description:
 */
public class P1 {


    public static int[] p = new int[2000005];

    public static void init() {
        for (int i = 2; i <= 2000000; i++) {
            if (p[i] == 0) {
                for (int j = i + i; j <= 2000000; j += i) {
                    p[j] = 1;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mem = new int[2 * n];

    }


}
