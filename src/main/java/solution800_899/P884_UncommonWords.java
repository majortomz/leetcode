package solution800_899;

import java.util.*;

/**
 * Created by zjw on 2018/08/15 20:40
 * Description:
 */
public class P884_UncommonWords {

    public String[] uncommonFromSentences(String A, String B) {
        String[] wa = A.split(" "), wb = B.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String word: wa) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(String word: wb) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String[] res = new String[map.size()];
        int last = 0;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                res[last++] = entry.getKey();
            }
        }
        return Arrays.copyOfRange(res, 0, last);
    }

}
