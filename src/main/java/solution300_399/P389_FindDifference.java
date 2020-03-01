package solution300_399;

/**
 * Created by zjw on 2017/6/20.
 */
public class P389_FindDifference {

    // Can be optimized, because t.length = s.length + 1;
    // int c, traverse s: c -= s[i]; traverse t: c += t.length; return (char)c
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if(map[t.charAt(i) - 'a'] <= 0)
                return t.charAt(i);
            map[index] -= 1;
        }
        return 0;
    }
}
