package leetcode_ms;

import java.util.Stack;

/**
 * Created by zjw on 2018/08/04 16:19
 * Description:
 */
public class P20 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == ')') {
                if(stack.empty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == ']') {
                if(stack.empty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.empty() || stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.empty();
    }

}
