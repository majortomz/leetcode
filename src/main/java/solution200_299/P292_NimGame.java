package solution200_299;

/**
 * Created by zjw on 2017/11/16.
 */
public class P292_NimGame {

    public boolean canWinNim(int n) {
        return helper(n, true);
    }

    public boolean helper(int n, boolean isMe) {
        if(n <= 3) {
            return isMe;
        }
        boolean result = false;
        for(int i = 1; i <= 3; i++) {
            result |= !helper(n - i, !isMe);
        }
        return result;
    }

}
