package solution800_899;

/**
 * Created by zjw on 2018/06/24 9:35
 * Description:
 */
public class P859_BuddyString {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        int state = 0, k = -1;
        int[] countA = new int[26];
        boolean single = true;
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i), b = B.charAt(i);
            countA[a - 'a']++;
            if(countA[a - 'a'] >= 2) {
                single = false;
            }
            if (A.charAt(i) == B.charAt(i)) {
                continue;
            }
            if (state == 0) {
                k = i;
                state = 1;
            } else {
                if (state == 2 || B.charAt(i) != A.charAt(k) || A.charAt(i) != B.charAt(k)) {
                    return false;
                }
                state = 2;
            }
        }
        return state == 2 || (state == 0 && single == false);
    }

}
