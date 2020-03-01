package newcoder.jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zjw on 2018/03/07 21:15
 * Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {
        String[] arr = new String[numbers.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                if(a.length() == b.length()) return a.compareTo(b);
                int k = Math.max(a.length(), b.length());
                int i = 0, j = 0;
                while(k > 0) {
                    if(a.charAt(i) != b.charAt(j)) {
                        return a.charAt(i) - b.charAt(j);
                    }
                    i = (i + 1) % a.length();
                    j = (j + 1) % b.length();
                    k--;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber pmn = new PrintMinNumber();
        System.out.println(pmn.PrintMinNumber(new int[]{321, 3, 32}));
    }
}
