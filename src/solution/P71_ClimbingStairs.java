package solution;

/**
 * Created by zjw on 2017/8/1.
 */
public class P71_ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        else if(n == 2)  return 2;
        int x = 1, y = 2;
        for(int i = 3; i <= n; i++) {
            int tmp = x + y;
            x = y;
            y = tmp;
        }
        return y;
    }
}
