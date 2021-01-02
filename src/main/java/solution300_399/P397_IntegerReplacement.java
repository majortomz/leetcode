package solution300_399;

/**
 * Created by zjw on 2017/10/24.
 */
public class P397_IntegerReplacement {

    public int integerReplacement(int n) {
        if(n <= 1)  return 0;
        else if(n == Integer.MAX_VALUE) return 32;
        if(n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
        }
    }

    // Solution 2, from leetcode discussion
    public int integerReplacement2(int n) {
        if(n <= 1)  return 0;
        int res = 0;
        while(n != 1) {
            if((n & 1) == 0) {
                // case 1: even, just divide 2
                n >>>= 1;
            } else if(n == 3 || (n >>> 1 & 1) == 0){
                // case 2: odd, consider n = 2k + 1, then n + 1 = 2k + 2; n - 1 = 2k;
                // (n+1)/2 = k + 1,  (n-1)/2 = k and we select n+1 as next choice if k+1 is even, else we select n-1
                // n == 3 is an exception
                n--;
            } else {
                n++;
            }
            res++;
        }
        return res;
    }

}
