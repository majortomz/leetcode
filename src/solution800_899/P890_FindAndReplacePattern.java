package solution800_899;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2018/08/19 9:52
 * Description:
 */
public class P890_FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String word: words) {
            if(isMatch(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isMatch(String word, String pattern) {
        if(word.length() != pattern.length()) {
            return false;
        }

        int n = word.length();
        int[] mapA = new int[256], mapB = new int[256];
        for(int i = 0; i < n; i++) {
            char a = word.charAt(i), b = pattern.charAt(i);
            if(mapA[a] == 0 && mapB[b] == 0) {
                mapA[a] = b;
                mapB[b] = a;
            } else if(mapA[a] != b || mapB[b] != a) {
                return false;
            }
        }
        return true;
    }

}
