package solution100_199;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zjw on 2017/9/28.
 */
public class P155_MinStack {

}

class MinStack {

    private List<Integer> list;
    private PriorityQueue<Integer> queue;

    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<>();
        queue = new PriorityQueue<>();
    }

    public void push(int x) {
        list.add(x);
        queue.add(x);
    }

    public void pop() {
        if(list.size() > 0) {
            Integer num = list.remove(list.size() - 1);
            queue.remove(num);
        }
    }

    public int top() {
        if(list.size() > 0)
            return list.get(list.size() - 1);
        else
            return 0;
    }

    public int getMin() {
        return queue.peek();
    }
}
