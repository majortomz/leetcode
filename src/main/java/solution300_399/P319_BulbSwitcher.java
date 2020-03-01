package solution300_399;

/**
 * Created by zjw on 2017/11/27.
 */
public class P319_BulbSwitcher {

    public int bulbSwitch(int n) {
        if(n <= 0)  return 0;
        boolean[] bulbs = new boolean[n];
        int count = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i-1; j < n; j += i) {
                bulbs[j] = !bulbs[j];
                if(bulbs[j])    count++;
                else    count--;
            }
        }
        return count;
    }

    // from leetcode discussion
    public int bulbSwitch2(int n) {
        return (int)Math.sqrt(n);
    }

}
