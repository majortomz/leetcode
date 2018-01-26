package solution300_399;

/**
 * Created by zjw on 2018/01/25 14:21
 * Description:
 */
public class P390_EliminationGame {

    public int lastRemaining(int n) {
        int left = 1, right = n;
        int k, b;
        boolean leftToRight = true;
        while (left != right && n > 1) {
            k = (right - left) / (n - 1);
            b = left - k;
            // get new right and left
            if (leftToRight) {
                left = k * 2 + b;
                right = n % 2 == 0 ? (k * n + b) : k * (n - 1) + b;
            } else {
                right = k * (n - 1) + b;
                left = n % 2 == 0 ? k + b : 2 * k + b;
            }
            leftToRight = !leftToRight;
            n /= 2;
        }
        return left;
    }

    // solution2, from leetcode discussion
    public int lastRemaining2(int n) {
        int head = 1, step = 1, count = n;
        boolean left = true;
        while (count > 1) {
            if (left || count % 2 == 1) {
                head += step;
            }

            step *= 2;
            count /= 2;
            left = !left;
        }
        return head;
    }
}
