package solution300_399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2018/01/23 14:44
 * Description:
 */
public class P372_SuperPow {

    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0 || (b.length == 1 && b[0] == 1)) {
            return a % 1337;
        }
        int d = a % 1337;
        int[] tempB = divBy2(b);
        return (b[b.length - 1] % 2 == 0 ? superPow(d * d, tempB) : d * superPow(d * d, tempB)) % 1337;
    }

    public int[] divBy2(int[] b) {
        int[] tempB = new int[b[0] > 1 ? b.length : b.length - 1];
        int c = 0;
        for (int i = 0, j = 0; i < b.length; i++) {
            if (i == 0 && b[i] <= 1) {
                c = 1;
            } else {
                tempB[j] = (b[i] + c * 10) / 2;
                c = (b[i] + c * 10) % 2;
                j++;
            }
        }
        return tempB;
    }

    class Solution2 {
        // leetcode discussion
        int base = 1337;

        public int superPow(int a, int[] b) {
            if (b == null || b.length == 0) {
                return 1;
            }
            return powmod(superPow(a, Arrays.copyOfRange(b, 0, b.length - 1)), 10) *
                    powmod(a, b[b.length - 1]) % base;
        }

        private int powmod(int a, int k) {
            a %= base;
            int result = 1;
            for(int i = 1; i <= k; i++) {
                result = (result * a) % base;
            }
            return result;
        }

    }

}
