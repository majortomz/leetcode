package solution700_799;

/**
 * Created by zjw on 2018/05/28 11:03
 * Description:
 */
public class P796_RotateString {

    public boolean rotateString(String A, String B) {
        if(A == null || B == null || A.length() != B.length()) {
            return false;
        }

        // return  (A + A).cotnains(B)....
        if(A.equals(B)) {
            return true;
        }

        int n = A.length();
        for(int i = 0; i < n; i++) {
            if(B.equals(A.substring(i) + A.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}
