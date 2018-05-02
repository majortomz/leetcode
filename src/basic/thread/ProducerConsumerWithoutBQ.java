package basic.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zjw on 2018/04/17 22:18
 * Description: 使用wait notify实现生产者消费者
 */
public class ProducerConsumerWithoutBQ {

    AtomicInteger atomic = new AtomicInteger();

    class Storage {
        private int index = 0;
        private final int MAX = 1;
        private List<Integer> buffer = new ArrayList<>();

        public synchronized void put(int item) {
            while(index >= MAX) {
                try {
                    System.out.println("无法生产, index " + index);
                    wait();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("开始生产, item:" + item + " index:" + index);
            buffer.add(0, item);
            index++;
            notify();
        }

        public synchronized int take() {
            while(index == 0) {
                try {
                    System.out.println("无法消费, index " + index);
                    wait();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            index--;
            int item = buffer.remove(index);
            System.out.println("开始消费, item:" + item);
            notify();
            return item;
        }

    }

    class Producer implements Runnable {

        Storage storage;
        AtomicInteger ai;

        public Producer(Storage storage, AtomicInteger ai) {
            this.storage = storage;
            this.ai = ai;
        }

        @Override
        public void run() {
            this.storage.put(this.ai.addAndGet(1));
            try{
                Thread.sleep(100);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable {
        Storage storage;
        AtomicInteger ai;

        public Consumer(Storage storage, AtomicInteger ai) {
            this.storage = storage;
            this.ai = ai;
        }

        @Override
        public void run() {
            this.storage.take();
            try{
                Thread.sleep(100);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void test() {
        Storage storage = new Storage();
        for(int i = 0; i < 20; i++) {
            new Thread(new Producer(storage, this.atomic)).start();
        }

        for(int i = 0; i < 20; i++) {
            new Thread(new Consumer(storage, this.atomic)).start();
        }

        try {
            Thread.sleep(100);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ProducerConsumerWithoutBQ pc = new ProducerConsumerWithoutBQ();
        pc.test();
    }

}
