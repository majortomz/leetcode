package solution700_799;

public class P788_RotatedDigits {

    public int rotatedDigits(int N) {
        if(N <= 0)  return 0;
        int d = 6, i = 1;
        int[] res = new int[d + 1], arr = new int[d + 1], helper = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3};
        arr[0] = 0;
        res[0] = 1;

        while(N > 0) {
            int k = N % 10;
            arr[i] = 4 * (int)Math.pow(10, i - 1) + 6 * arr[i - 1];
            res[i] = helper[k] * (int)Math.pow(10, i - 1) + (k  - helper[k]) * arr[i - 1]  +  (k & 1) * res[i - 1];
            N /= 10;
            i++;
        }
        return res[i - 1];
    }

}
