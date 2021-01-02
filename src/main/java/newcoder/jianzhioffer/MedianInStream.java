package newcoder.jianzhioffer;

import java.util.PriorityQueue;

/**
 * Created by zjw on 2018/04/23 14:45
 * Description:
 */
public class MedianInStream {


    private PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> (b - a)), even = new PriorityQueue<>();

    private int count = 0;

    public void Insert(Integer num) {
        count++;
        odd.add(num);
        if(odd.size() - even.size() > 1) {
            even.add(odd.poll());
        }
        while(count > 2 && even.peek() < odd.peek()) {
            Integer tmp = even.poll();
            even.add(odd.poll());
            odd.add(tmp);
        }
    }

    public Double GetMedian() {
        if(count == 0)  {
            return 0.0;
        } else {
            return (count & 1) == 0 ? (odd.peek() + even.peek()) / 2.0 : odd.peek() * 1.0;
        }
    }

}
