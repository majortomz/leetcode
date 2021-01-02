package solution300_399;

/**
 * Created by zjw on 2017/10/13.
 */
public class P342_PowerOfFour {

    public boolean isPowerOfFour(int num) {
        int x = 0x55555555;
        return num > 0 && (num & x) != 0 && (num & (num - 1)) == 0;
    }

}
