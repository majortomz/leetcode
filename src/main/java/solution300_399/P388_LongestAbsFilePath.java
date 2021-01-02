package solution300_399;

import java.util.Stack;

/**
 * Created by zjw on 2018/01/24 13:32
 * Description:
 */
public class P388_LongestAbsFilePath {

    public int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int max = 0, len = 0;
        while(i < input.length()) {
            int count = 0;
            while(i < input.length() && (input.charAt(i) == '\n' || input.charAt(i) == '\t')) {
                if(input.charAt(i+1) == '\t')
                    count++;
                i++;
            }

            int next = input.indexOf('\n', i);
            String sub = input.substring(i, next == -1 ? input.length() : next);
            while(stack.size() > count) {
                len -= (stack.pop().length() + 1);
            }

            if(sub.indexOf('.') != -1) {
                max = Math.max(max, len + sub.length());
            } else {
                stack.push(sub);
                len += (sub.length() + 1);
            }
            i += sub.length();
        }
        return max;
    }

}
