package solution400_499;

/**
 * Created by zjw on 2017/5/26.
 */
public class P495_TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0)    return 0;
        int res = 0;
        for(int i = 1; i < timeSeries.length; i++)
        {
            int delta = timeSeries[i] - timeSeries[i-1];
            res += Math.min(duration, delta);
        }
        res += duration;
        return res;
    }
}
