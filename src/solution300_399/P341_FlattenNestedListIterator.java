package solution300_399;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by zjw on 2018/01/17 9:48
 * Description:
 */


public class P341_FlattenNestedListIterator {
    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    class NestedIterator implements Iterator<Integer> {
        Stack<Iterator> stack = new Stack<>();
        Integer next;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return next;
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (!stack.peek().hasNext()) {
                    stack.pop();
                } else {
                    NestedInteger nextObj = (NestedInteger) stack.peek().next();
                    if (nextObj.isInteger()) {
                        next = nextObj.getInteger();
                        return true;
                    } else {
                        stack.push(nextObj.getList().iterator());
                    }
                }
            }
            return false;
        }
    }
}
