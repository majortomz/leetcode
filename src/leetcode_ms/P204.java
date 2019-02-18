package leetcode_ms;

/**
 * Created by zjw on 2018/08/05 16:40
 * Description:
 */
public class P204 {

    public int countPrimes(int n) {
        if(n <= 2) {
            return 1;
        }

        int count = 0;
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
            if(notPrime[i]) {
                continue;
            }

            count++;
            for(int j = i * 2; j < n; j += i) {
                notPrime[j] = true;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        if(n <= 2) {
            return n == 2;
        }
        int bound = (int)Math.sqrt(n);
        for(int i = 2; i <= bound; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
