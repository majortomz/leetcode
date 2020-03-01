package basic.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjw on 2018/08/25 20:42
 * Description:
 */
public class ProducerConsumerWaitNotify {


    class Storage {
        LinkedList<Integer> buffer = new LinkedList<>();
        int max = 100;

        public Storage(int max) {
            this.max = max;
        }

        public synchronized void produce(int item) {
            try {
                while(buffer.size() == max) {
                    wait();
                    System.out.println("buffer full, can not produce");
                }
                buffer.add(item);
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public synchronized int consume() {
            int item = -1;
            try {
                while(buffer.size() == 0) {
                    wait();
                    System.out.println("buffer empty, can not consume");
                }
                item = buffer.pollFirst();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return item;
        }
    }


}
