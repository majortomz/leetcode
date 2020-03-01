package basic.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zjw on 2018/03/13 9:51
 * Description: 生产者，消费者；采用BlockingQueue实现
 */
public class ProducerConsumer {

    class Producer implements Runnable {

        BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                String tmp = "A product. 生产者：" + Thread.currentThread().getName();
                System.out.println("I produce a product" + Thread.currentThread().getName());
                queue.put(tmp);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable {
        BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                String tmp = queue.take();
                System.out.println(Thread.currentThread().getName() + tmp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test() throws Exception{
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(2);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        for(int i = 0; i < 5; i++) {
            new Thread(producer, "Producer" + i).start();
            new Thread(consumer, "Consumer" + i).start();
        }
    }

    public static void main(String[] args) throws Exception{
        ProducerConsumer pc = new ProducerConsumer();
        pc.test();
    }
}
