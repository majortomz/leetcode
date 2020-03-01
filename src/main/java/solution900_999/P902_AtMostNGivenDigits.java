package solution900_999;

/**
 * Created by zjw on 2018/09/09 10:28
 * Description:
 */
public class P902_AtMostNGivenDigits {

    public int atMostNGivenDigitSet(String[] D, int N) {
        int[] counts = new int[10];
        boolean[] set = new boolean[10];

        int maxDigit = 0;
        for(int i = 1, j = 0; i <= 9; i++) {
            if(j < D.length && i == Integer.valueOf(D[j])) {
                set[i] = true;
                counts[i] = counts[i - 1] + 1;
                maxDigit = i;
                j++;
            } else {
                counts[i] = counts[i - 1];
            }
        }


        int full = counts[maxDigit], fullTmp = counts[maxDigit], actual = counts[N % 10];
        while(N / 10 > 0) {
            N /= 10;
            int cur = N % 10;

            actual = (cur == 0 ? 0 : counts[cur - 1] + 1) * full + (set[cur] ? actual: 0);

            fullTmp = fullTmp * counts[maxDigit];
            full += fullTmp;
        }

        return actual;
    }

}
