package solution300_399;

/**
 * Created by zjw on 2018/01/18 19:16
 * Description:
 */
public class P367_PerfectValidSquare {

    public boolean isPerfectSquare(int num) {
        if(num <= 1) return num == 1;
        int low = 0, high = num / 2;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(num / mid == mid) {
                return num % mid == 0;
            } else if(num / mid > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

}
