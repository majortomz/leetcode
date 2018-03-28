package newcoder.wangyi.code2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by zjw on 2018/03/26 20:29
 * Description:
 */
public class Problem4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] parent = new int[n];
        int[] len = new int[n];
        int max = 0;
        for(int i = 1; i < n; i++) {
            parent[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i++) {
            int cur = i, step = 1;
            while(parent[cur] != 0) {
                cur = parent[cur];
                step++;
            }
            len[i] = step;
            max = Math.max(len[i], 1);
        }
        System.out.println(1 + Math.min(l, max));

    }

}
