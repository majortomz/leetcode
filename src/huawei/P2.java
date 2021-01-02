package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String exp = sc.nextLine();
            long a = 0, b = 0;
            boolean left = true;
            List<Character> symbols = new ArrayList<>();

            int i = 0;
            if('0' > exp.charAt(i) || exp.charAt(i) > '9') {
                symbols.add(exp.charAt(0));
                i = 1;
            }
            while(i < exp.length()) {
                if('0' <= exp.charAt(i) && exp.charAt(i) <= '9') {
                    if(left)
                        a = a * 10 + exp.charAt(i) - '0';
                    else
                        b = b * 10 + exp.charAt(i) - '0';
                } else {
                    symbols.add(exp.charAt(i));
                    left = false;
                }
                i++;
            }
            if(symbols.size() == 2) {
                a *= (symbols.get(0) == '-' ?  -1 : 1);
            }

            switch (symbols.get(symbols.size() - 1)) {
                case '*' : System.out.println(a * b);   break;
                case '/': System.out.println(a / b);    break;
                case '+': System.out.println(a + b);    break;
                case '-':  System.out.println(a - b);
            }
        }
    }
}
