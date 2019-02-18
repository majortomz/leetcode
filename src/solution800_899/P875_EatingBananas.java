package solution800_899;

/**
 * Created by zjw on 2018/08/03 9:23
 * Description:
 */
public class P875_EatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        int min = 0, max = Integer.MIN_VALUE;
        for(int pile: piles) {
            min += pile;
            max = Math.max(min, max);
        }
        min = min / H + (min % H == 0 ? 0 : 1);

        while(min < max) {
            int mid = min + (max - min) / 2;
            int h = 0;
            for(int pile: piles) {
                h += (pile / mid + (pile % mid == 0 ? 0 : 1));
            }
            if(h > H) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

}
