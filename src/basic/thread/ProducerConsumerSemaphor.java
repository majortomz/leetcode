package basic.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zjw on 2018/08/25 20:08
 * Description:
 */
public class ProducerConsumerSemaphor {
    AtomicInteger atomicInteger = new AtomicInteger();

    class Storage {

        Semaphore fullSlot, emptySlot, mutex;
        LinkedList<Integer> buffer = new LinkedList<>();

        public Storage(int size) {
            this.emptySlot = new Semaphore(size);
            this.fullSlot = new Semaphore(0);
            this.mutex = new Semaphore(1);
        }


        public void produce(int item) {
            try {
                emptySlot.acquire();
                mutex.acquire();
                buffer.add(item);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                mutex.release();
                fullSlot.release();
            }
        }

        public int consume() {
            int item = 0;
            try {
                fullSlot.acquire();
                mutex.acquire();
                item = buffer.pollFirst();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                mutex.release();
                emptySlot.release();
            }
            return item;
        }
    }


    class Consumer implements Runnable {

        private Storage storage;

        public Consumer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                int item = this.storage.consume();
                System.out.println("");
                // process
            }
        }
    }

    class Producer implements Runnable {

        private Storage storage;

        public Producer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                this.storage.produce(atomicInteger.getAndIncrement());
            }
        }
    }

}
