package solution200_299;

/**
 * Created by zjw on 2017/6/21 10:59.
 */
public class P204_CountPrimes {

    public int countPrimes2(int n) {
        boolean[] visited = new boolean[n];
        int count = 0;
        // i cac be initialized to 3, and let step is 2, because we can ignore even
        for(int i = 2; i < n; i++) {
            if(visited[i])  continue;
            count++;
            for(int k = i; k < n; k+= i) {
                visited[k] = true;
            }
        }
        return count;
    }

    // TLE
    public int countPrimes(int n) {
        boolean[] visited = new boolean[n];
        int count = 0, upper = (int)Math.sqrt(n);
        for(int i = 2; i < n; i++) {
            if(visited[i])  continue;
            if(isPrime(i))
                count++;
            int k = i;
            while(k <= upper) {
                visited[k] = true;
                k *= k;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        if(n <= 1)  return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

}
