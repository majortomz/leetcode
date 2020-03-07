package solution1100_1199;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Description:
 *
 * @author lanling.zjw date: 2020/03/07 17:29
 */
public class P1117_BuildingH2O {

    class H2O {

        private final Object hLock = new Object();
        private final Object oLock = new Object();

        private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        private int hPermits = 2;

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

           synchronized (hLock){
                // releaseHydrogen.run() outputs "H". Do not change or remove this line.
               if (hPermits >= 2) {
                   releaseHydrogen.run();
                   hPermits--;
               } else {
                   try {
                       releaseHydrogen.run();
                       cyclicBarrier.await();
                       hPermits = 2;
                   } catch (Exception e) {
                   }
               }
            }

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            synchronized (oLock) {
                releaseOxygen.run();
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {

                }
            }

        }
    }

}
