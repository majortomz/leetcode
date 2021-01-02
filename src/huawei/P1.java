package huawei;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String cur = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            String[] arr = cur.split(" ");
            for(int i = arr.length - 1; i >= 0; i--) {
                sb.append(arr[i]);
                if(i != 0) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
