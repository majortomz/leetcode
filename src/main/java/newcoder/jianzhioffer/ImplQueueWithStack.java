package newcoder.jianzhioffer;

import java.util.Stack;

/**
 * Created by zjw on 2018/03/01 16:06
 * Description:
 */
public class ImplQueueWithStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(node);
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

}
