package huawei;

import java.util.Scanner;

public class P3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        long[] prices = new long[strings.length + 1], profit = new long[strings.length + 1];
        for(int i = 0; i < strings.length; i++) {
            boolean flag = false;
            if(strings[i].charAt(strings[i].length() - 1) == 'S') {
                flag = true;
            }
            prices[i + 1] = Long.valueOf(strings[i].substring(0, strings[i].length() - 1));
            if(flag) {
                prices[i + 1] *= 7;
            }
        }

        int len = strings.length + 1;
        for(int i = 1; i < len; i++) {
            profit[i] = profit[i - 1];
            for(int j = 1; j < i; j++) {
                profit[i] = Math.max(profit[i], profit[j - 1] + prices[i] - prices[j]);
            }
        }

        System.out.println(profit[len - 1]);
    }
}
