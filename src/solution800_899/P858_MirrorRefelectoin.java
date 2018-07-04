package solution800_899;

/**
 * Created by zjw on 2018/06/24 10:07
 * Description:
 */
public class P858_MirrorRefelectoin {

    // ac, simulate reflection
    public int mirrorReflection(int p, int q) {

        boolean right = false, up = true;
        int y = 0;
        while(true) {
            right = !right;
            if(up) {
                if(p - y == q) {
                    return right ? 1 : 2;
                }
                if(p - y > q) {
                    y += q;
                } else {
                    y = p - (q - (p - y));
                    up = false;
                }
            } else {
                if(y - q == 0) {
                    return 1;
                }
                if(y > q) {
                    y -= q;
                } else {
                    y = q - y;
                    up = true;
                }
            }
        }
    }

    // from leetcode discussion
    public int mirrorReflection2(int p, int q) {

        /*
        It can be expanded to this...
        ...
        |-0
        | |
        2-1
        | |
        |-0
        | |
        2-1
        | |
        |-0
        you just need to know ?q=kp (?,k belong to Z)
        */

        int k = 1;
        while(q * k % p != 0) {
            k++;
        }

        int n = q * k / p;
        if(n % 2 == 0 && k % 2 == 1) {
            return 0;
        }
        if(n % 2 != 0 && k % 2 == 1) {
            return 1;
        }
        if(n % 2 != 0 && k % 2 == 0) {
            return 2;
        }
        return -1;
    }

}
