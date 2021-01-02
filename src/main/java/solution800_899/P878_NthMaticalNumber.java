package solution800_899;

/**
 * Created by zjw on 2018/07/29 10:40
 * Description:
 */
public class P878_NthMaticalNumber {

    // from leetcode, mathematical solution
    public int nthMagicalNumber(int N, int A, int B) {
        int mod = 1_000_000_007;
        int L = A / gcd(A, B) * B;  // least common multiple
        int M = L / A + L / B - 1;  // number of magical number within a LCM
        int q = N / M, r = N % M;

        long ans = (long)L * q % mod;
        if(r == 0) {
            return (int)ans;
        }

        int nextA = A, nextB = B;
        for(int i = 1; i < r; i++) {
            if(nextA == nextB) {
                nextA += A;
                nextB += B;
            } else if(nextA < nextB) {
                nextA += A;
            } else {
                nextB += B;
            }
        }
        ans = (ans + Math.min(nextA, nextB)) % mod;
        return (int)ans;
    }

    // from leetcode discussion, binary search
    public int nthMagicalNumber2(int N, int A, int B) {
        int mod = 1_000_000_007;
        int lcm = A / gcd(A, B) * B;
        long low = 0, high = (long)1e14;

        while(low < high) {
            long mid = low + (high - low) / 2;
            if(mid / A + mid / B - mid / lcm < N) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int)(low % mod);
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
