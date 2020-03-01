package solution200_299;

/**
 * Created by zjw on 2017/11/16.
 */
public class P279_PerfectSquares {

    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i) {
                arr[i] = 1;
                continue;
            }
            int mid = i / 2;
            arr[i] = Integer.MAX_VALUE;
            for(int k = 1; k <= mid; k++) {
                arr[i] = Math.min(arr[k] + arr[i - k], arr[i]);
            }
        }
        return arr[n];
    }

    public int numSquares2(int n) {
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i) {
                arr[i] = 1;
                continue;
            }
            arr[i] = Integer.MAX_VALUE;
            for(int k = 1; k <= sqrt; k++) {
                arr[i] = Math.min(1 + arr[i - k * k], arr[i]);
            }
        }
        return arr[n];

    }

}
