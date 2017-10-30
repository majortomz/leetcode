package solution200_299;

import java.util.Stack;

/**
 * Created by zjw on 2017/10/30.
 */
public class P213_ImplementQueue {
    class MyQueue {

        Stack<Integer> stack, stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while(!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            stack.push(x);
            while(!stack2.isEmpty()) {
                stack.push(stack2.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }

}
