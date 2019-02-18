package leetcode_ms;

/**
 * Created by zjw on 2018/08/06 19:22
 * Description:
 */
public class P125 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int lo = 0, hi = s.length() - 1;
        while(lo <= hi) {
            if(!(Character.isAlphabetic(s.charAt(lo)) || Character.isDigit(s.charAt(lo)))) {
                lo++;
                continue;
            }
            if(!(Character.isAlphabetic(s.charAt(hi)) || Character.isDigit(s.charAt(hi)))) {
                hi--;
                continue;
            }
            if(s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

}
