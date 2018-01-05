package solution600_699;

/**
 * Created by zjw on 2017/12/20.
 */
public class P686_RepeatedStrignMatch {

    public int repeatedStringMatch(String A, String B) {
        char[] charsA = A.toCharArray(), charsB = B.toCharArray();
        if(A.contains(B)) {
            return 1;
        }
        int lt = B.indexOf(A);
        if(lt == -1) {
            return (A + A).contains(B) ? 2 : -1;
        }
        int rt = B.lastIndexOf(A);
        if(lt > charsA.length || (rt + charsA.length * 2) < charsB.length)
            return -1;

        int count = lt == 0 ? 0 : 1;
        for(int i = lt - 1, j = charsA.length - 1; i >= 0 && j >= 0; i--, j--) {
            if(charsA[j] != charsB[i]) {
                return -1;
            }
        }
        for(int i = lt, j = 0; i < charsB.length; i++, j = (j+1) % charsA.length) {
            if(charsA[j] != charsB[i]) {
                return -1;
            }
            if(j == 0) {
                count++;
            }
        }
        return count;
    }

}
