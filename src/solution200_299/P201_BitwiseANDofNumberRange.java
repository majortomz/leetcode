package solution200_299;

/**
 * Created by zjw on 2017/10/17.
 */
public class P201_BitwiseANDofNumberRange {

    public int rangeBitwiseAnd(int m, int n) {
        if(m == n)  return m;
        int res = 0;
        for(int i = 31; i >= 0; i--) {
            int a = (m >> i) & 1, b = (n >> i) & 1;
            if(a == b) {
                res |= (a << i);
            } else {
                break;
            }
        }
        return res;
    }

}
