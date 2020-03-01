package solution800_899;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zjw on 2018/04/15 16:47
 * Description:
 */
public class P819_MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String res = null;
        for(String ban : banned) {
            banSet.add(ban);
        }
        for(String str : paragraph.split("!|\\?|'|,|;|\\.|\\s")) {
            if(str.length() == 0)   continue;
            String lower = str.toLowerCase();
            if(!banSet.contains(lower)) {
                map.put(lower, map.getOrDefault(lower, 0) + 1);
                if(map.get(lower) > max) {
                    max = map.get(lower);
                    res = lower;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        mostCommonWord("Bob. hIt, baLl", new String[] {"bob", "hit"});
    }
}
