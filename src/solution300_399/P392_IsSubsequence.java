package solution300_399;

/**
 * Created by zjw on 2017/8/4.
 */
public class P392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null)  return false;

        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++; j++;
            }
            else
                j++;
        }
        if(i == s.length())
            return true;
        else
            return false;
    }

    // from leetcode discussion
    public boolean isSubsequence2(String s, String t) {
        int index = 0;

        for(int i = 0; i < s.length(); ++i) {
            index = t.indexOf(s.charAt(i), index);

            if(index < 0) {
                return false;
            }

            index++;
        }

        return true;
    }

}
