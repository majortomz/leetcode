package solution200_299;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2017/6/19.
 */
public class P290_WordPattern {

    // Wrong Answer, misunderstand the problem
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || pattern.length() == 0 ||str == null || str.length() == 0)    return false;
        String[] sub = str.split(" ");
        if(pattern.length() != sub.length || sub.length * sub[0].length() + sub.length - 1 != str.length())
            return false;
        for(int i = 0; i < sub[0].length(); i++) {
            int[] map = new int[26], bmap = new int[26];
            int j = 0;
            for(String s : sub) {
                char c = s.charAt(i), cp = pattern.charAt(j);
                if(map[cp - 'a'] == 0 && bmap[c - 'a'] == 0) {
                    map[cp - 'a'] = c;
                    bmap[c - 'a'] = cp;
                }
                else if(!(map[cp - 'a'] == c && bmap[c - 'a'] == cp))
                    return false;
                j++;
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        if(pattern == null || pattern.length() == 0 ||str == null || str.length() == 0)    return false;
        String[] words = str.split(" ");
        if(pattern.length() != words.length)
            return false;
        HashMap<Character, Integer> mapc = new HashMap<>();
        HashMap<String, Integer> maps = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(!mapc.containsKey(c) && !maps.containsKey(words[i])) {
                mapc.put(c, i);
                maps.put(words[i], i);
            }
            else if(!(mapc.containsKey(c) && maps.containsKey(words[i]) && mapc.get(c).equals(maps.get(words[i]))))
                return false;
        }
        return true;
    }

}
