package solution400_499;

/**
 * Created by zjw on 2017/6/20 19:20.
 */
public class P409_LongestPalindrome {

    public int longestPalindrome(String s) {
        boolean[] map = new boolean[128];
        int odd = 0, res = 0;
        for(char c : s.toCharArray()) {
            if(map[c]) {
                res += 2;
                odd--;
            } else {
                odd++;
            }
            map[c] = !map[c];
        }
        return odd == 0 ? res : res + 1;
    }

}
