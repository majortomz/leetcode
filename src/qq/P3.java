package qq;

import java.util.Scanner;

/**
 * Created by zjw on 2018/09/16 11:09
 * Description:
 */
public class P3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int start = A % B;
            int k = 2;
            int tmp = (start * k) % B;
            while (tmp != start) {
                if (tmp == C) {
                    break;
                }
                k++;
                tmp = (start * k) % B;
            }
            if (tmp == C) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
