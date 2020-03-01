package solution800_899;

/**
 * Created by zjw on 2018/07/15 9:32
 * Description:
 */
public class P868_BinaryGap {

    public int binaryGap(int N) {
        int max = 0;
        char[] digits = Integer.toBinaryString(N).toCharArray();
        int prev = -1;
        for(int i = 0; i < digits.length; i++) {
            if(digits[i] == '1') {
                if(prev != -1) {
                    max = Math.max(max, i - prev);
                }
                prev = i;
            }
        }
        return max;
    }

}
