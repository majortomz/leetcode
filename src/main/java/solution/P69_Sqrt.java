package solution;

/**
 * Created by zjw on 2017/9/22.
 */
public class P69_Sqrt {

    public int mySqrt(int x) {
        if(x <= 0)  return x;
        int lt = 0, rt = x / 2;
        long multi, mid;
        while(lt <= rt) {
            mid = (lt + rt) / 2;
            multi = mid * mid;
            if(multi > x) {
                rt = (int)mid - 1;
            } else if(multi < x) {
                lt = (int)mid + 1;
            } else
                return (int)mid;
        }
        return rt;
    }

}
