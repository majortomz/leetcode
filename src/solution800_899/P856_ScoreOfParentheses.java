package solution800_899;

import java.util.Stack;

/**
 * Created by zjw on 2018/06/24 9:53
 * Description:
 */
public class P856_ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> counter = new Stack<>();

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                counter.push(-1);
            } else {
                int tmpScore = 0;
                while(!counter.isEmpty()) {
                    int top = counter.pop();
                    if(top == -1) {
                        break;
                    } else {
                        tmpScore += top;
                    }
                }
                counter.push(tmpScore == 0 ? 1 : 2 * tmpScore);
            }
        }
        int res = 0;
        while(!counter.isEmpty()) {
            res += counter.pop();
        }
        return res;
    }

}
