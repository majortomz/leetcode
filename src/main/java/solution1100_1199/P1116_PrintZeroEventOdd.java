package solution1100_1199;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Description:
 *
 * @author zjw date: 2020/03/01 16:05
 */
public class P1116_PrintZeroEventOdd {


    class ZeroEvenOdd {

        private int n;

        private Semaphore evenCanPrint = new Semaphore(1);
        private Semaphore oddCanPrint = new Semaphore(0);
        private Semaphore roundCompleted = new Semaphore(0);

        public ZeroEvenOdd(int n) {

            this.n = n;
            try {
                evenCanPrint.acquire();
                oddCanPrint.acquire();
            } catch (Exception e) {

            }

        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                roundCompleted.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    oddCanPrint.release();
                } else {
                    evenCanPrint.release();
                }
            }

        }


        public void even(IntConsumer printNumber) throws InterruptedException {

            for (int cur = 2; cur <= n; cur += 2) {
                evenCanPrint.acquire();
                printNumber.accept(cur);
                roundCompleted.release();
            }
        }


        public void odd(IntConsumer printNumber) throws InterruptedException {

            for (int cur = 1; cur <= n; cur += 2) {
                oddCanPrint.acquire();
                printNumber.accept(cur);
                roundCompleted.release();
            }
        }

    }


}
