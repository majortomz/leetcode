package solution800_899;

/**
 * Created by zjw on 2018/05/21 20:43
 * Description:
 */
public class P837_New21Game {

    public double new21Game(int N, int K, int W) {
        if(K > N) {
            return 0;
        }
        if(K == 0) {
            return 1;
        }
        double[] dp = new double[K + W];
        // 保留某个区间的和，区间大小最大为W
        double window = 0;
        int n = dp.length;
        for(int i = 1; i < n; i++) {
            dp[i] = window;
            if(i <= W) {
                dp[i] += 1;
            }
            dp[i] /= W;
            if(i > W) {
                window -= dp[i - W];
            }
            if(i < K) {
                window += dp[i];
            }
        }
        double sum = 0, count = 0;
        for(int i = K; i < n; i++) {
            sum += dp[i];
            if(i <= N) {
                count += dp[i];
            }
        }
        return count / sum;
    }

}
