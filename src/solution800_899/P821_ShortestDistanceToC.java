package solution800_899;

/**
 * Created by zjw on 2018/04/22 9:31
 * Description:
 */
public class P821_ShortestDistanceToC {

    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];

        int[] forward = new int[S.length()];
        char[] words = S.toCharArray();

        int prev = -1;
        for(int i = 0   ; i < words.length; i++) {
            if(words[i] == C) {
                prev = i;
                forward[i] = 0;
            } else {
                forward[i] = prev == -1 ? Integer.MAX_VALUE : i - prev;
            }
        }

        prev = -1;
        for(int i = words.length - 1; i >= 0; i--) {
            if(words[i] == C) {
                prev = i;
                res[i] = 0;
            } else {
                res[i] = prev == -1 ? forward[i] : Math.min(forward[i], prev - i);
            }
        }
        return res;
    }
}
