package solution1100_1199;

import java.util.concurrent.Semaphore;

/**
 * Description:
 *
 * @author zjw date: 2020/03/01 15:50
 */
public class P1115_PrintAlternately {


    class FooBar {

        Semaphore foo = new Semaphore(1);
        Semaphore bar = new Semaphore(1);

        private int n;

        public FooBar(int n) {
            this.n = n;
            try {
                foo.acquire();
            } catch (Exception e) {
                // ignore
            }

        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                bar.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                foo.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                foo.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                bar.release();
            }
        }
    }

}
