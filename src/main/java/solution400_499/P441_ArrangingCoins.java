package solution400_499;

/**
 * Created by zjw on 2018/01/31 13:39
 * Description:
 */
public class P441_ArrangingCoins {

    public int arrangeCoins(int n) {
        int i = 0;
        while(n > i) {
            i++;
            n -= i;
        }
        return i;
    }

    public int arrangeCoins2(int n) {
        return (int)((Math.sqrt(1 + 8 * n) - 1) / 2);
    }

}
