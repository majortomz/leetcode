package basic.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by zjw on 2018/03/12 21:45
 * Description:
 */
public class ExecutorCase {

    private static Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for(int i = 1; i <= 20; i++) {
            executor.execute(new Task());
        }
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

}
