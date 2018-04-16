package solution800_899;

/**
 * Created by zjw on 2018/04/08 10:00
 * Description:
 */
public class P813_LargestSumOfAverages {

    private double[][][] cache;

    public double largestSumOfAverages(int[] A, int K) {
        cache = new double[A.length][A.length][K + 1];
        return helper(A, 0, A.length - 1, K);
    }

    public double helper(int[] A, int start, int end, int k) {
        if(k <= 0)  return 0;
        if(cache[start][end][k] > 0)    return  cache[start][end][k];

        double sum = 0, max = 0;
        if(k == 1) {
            for(int i = start; i <= end; i++) {
                sum += A[i];
            }
            max = sum / (end - start + 1);
        } else {
//            also ac, 使用bound来防止剩下的元素个数不足以划分为 (k - 1)个区间
//            int bound = end - k + 1;
//            for(int i = start; i <= bound ; i++) {
//                sum += A[i];
//                max = Math.max(max, sum / (i - start + 1) + helper(A, i + 1, end, k - 1));
//            }
            for(int i = start; i <= end; i++) {
                sum += A[i];
                max = Math.max(max, sum / (i - start + 1) + helper(A, i + 1, end, k - 1));
            }
        }
        cache[start][end][k] = max;
        return max;
    }

}
