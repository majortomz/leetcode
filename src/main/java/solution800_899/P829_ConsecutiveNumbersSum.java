package solution800_899;

/**
 * Created by zjw on 2018/05/06 10:09
 * Description:
 */
public class P829_ConsecutiveNumbersSum {

    public static int consecutiveNumbersSum(int N) {
        if(N < 0) {
            return 0;
        }
        N *= 2;
        int max = (int)Math.sqrt(N);
        int count = 0;
        for(int len = 1; len <= max; len++) {
            if(N % len == 0 && (N / len + 1 - len) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(6));
    }

}
