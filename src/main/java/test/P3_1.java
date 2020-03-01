package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zjw on 2018/08/30 19:26
 * Description:
 */
public class P3_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt();
            int start = 0, len = 0;

            a %= b;
            if(a == 0) {
                System.out.println(start + " " + len);
            }

            Map<Integer, Integer> map = new HashMap<>();
            while(a != 0) {
                a *= 10;
                a %= b;
                if(map.containsKey(a)) {
                    start = map.get(a);
                    len = String.valueOf(a).length();
                    break;
                } else {
                    map.put(a, start);
                    start++;
                }
            }

            System.out.println(start + " " + len);

            sc.nextLine();
        }

    }

}
