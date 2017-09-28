package solution100_199;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by zjw on 2017/9/27.
 */
public class P150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> symbols = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for(String token : tokens) {
//            if(token.matches("-?\\d+")) {
//                stack.push(Integer.valueOf(token));
//                continue;
//            }
            if(!symbols.contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int b = stack.pop(), a = stack.pop();
            int res = 0;
            switch(token) {
                case "+" :
                    res = a + b;    break;
                case "*":
                    res = a * b;    break;
                case "-":
                    res = a - b;    break;
                case "/":
                    res = a / b;    break;
                default:
                    break;
            }
            stack.push(res);
        }
        return stack.pop();
    }

}
