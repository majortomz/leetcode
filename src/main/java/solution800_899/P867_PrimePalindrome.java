package solution800_899;

/**
 * Created by zjw on 2018/07/09 20:36
 * Description:
 */
public class P867_PrimePalindrome {

    public int primePalindrome(int N) {
        if(N <= 2) {
            return 2;
        }
        int n = N % 2 == 0 ? N + 1 : N;
        while(true) {
            if(isPrime(n) && isPalindrome(n)) {
                return n;
            }
            if (10_000_000 <= n && n <= 100_000_000)
                n = 100_000_000 - 1;
            n += 2;
        }

    }

    private boolean isPrime(int n) {
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

    private boolean isPalindrome(int n) {
        int m = n;
        int r = 0;
        while(m > 0) {
            r = r * 10 + (m % 10);
            m /= 10;
        }
        return n == r;
    }

    public static void main(String[] args) {
        P867_PrimePalindrome pp = new P867_PrimePalindrome();
        System.out.println(pp.primePalindrome(9989900));
    }

}
