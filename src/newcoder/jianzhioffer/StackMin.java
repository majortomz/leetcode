package newcoder.jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by zjw on 2018/03/02 19:43
 * Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

 */
public class StackMin {

    List<Integer> list = new ArrayList<>(), minList = new ArrayList<>();

    public void push(int node) {
        if(list.size() > 0)
            minList.add(Math.min(node, minList.get(minList.size() - 1)));
        else
            minList.add(node);
        list.add(node);
    }

    public void pop() {
        list.remove(list.size() - 1);
        minList.remove(minList.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int min() {
        return minList.get(minList.size() - 1);
    }

}
