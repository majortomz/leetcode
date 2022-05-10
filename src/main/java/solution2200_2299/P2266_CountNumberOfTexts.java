package solution2200_2299;

/**
 * Created by zjw on 2022/05/10 21:35
 * Description:
 */
public class P2266_CountNumberOfTexts {

    public int countTexts(String pressedKeys) {
        char previous = '0';
        long res = 1, cur = 1;
        long[] dp = new long[5];
        int idx = -1;
        for (int i = 0; i < pressedKeys.length(); i++) {
            char c = pressedKeys.charAt(i);
            if (c != previous) {
                previous = c;
                res %= (1_000_000_000 + 7);
                cur %= (1_000_000_000 + 7);
                res = (res * cur) % (1_000_000_000 + 7);
                idx = -1;
                dp = new long[5];
            }
            int size = 3;
            if (c == '7' || c == '9') {
                size = 4;
            }
            idx++;
            if (idx < size) {
                cur = 1;
            } else {
                cur = 0;
            }
            for (int j = 0; j < size; j++) {
                cur += dp[j];
                cur %= (1_000_000_000 + 7);
            }
            dp[idx % size] = cur;
        }
        res %= (1_000_000_000 + 7);
        cur %= (1_000_000_000 + 7);
        return (int)((res * cur) % (1_000_000_000 + 7));
    }
}
