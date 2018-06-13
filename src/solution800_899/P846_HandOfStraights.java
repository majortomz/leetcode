package solution800_899;

import java.util.Arrays;

/**
 * Created by zjw on 2018/06/03 15:27
 * Description:
 */
public class P846_HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length == 0 || hand.length % W != 0) {
            return false;
        }
        if(W == 1) {
            return true;
        }

        int[][] counts = new int[hand.length][2];
        int len = 1;
        Arrays.sort(hand);
        counts[0] = new int[]{hand[0], 1};
        for(int i = 1; i < hand.length; i++) {
            if(hand[i] == hand[i - 1]) {
                counts[len - 1][1]++;
            } else {
                counts[len] = new int[]{hand[i], 1};
                len++;
            }
        }

        int count = 0;
        for(int i = len - 1; i >= W - 1; i--) {
            if(counts[i][1] == 0) {
                continue;
            }
            count += counts[i][1];
            for(int j = 1; j < W; j++) {
                if(counts[i - j][0] != counts[i][0] - j || counts[i - j][1] < counts[i][1]) {
                    return false;
                }
                counts[i - j][1] -= counts[i][1];
            }
        }
        return count * W == hand.length;
    }

}
