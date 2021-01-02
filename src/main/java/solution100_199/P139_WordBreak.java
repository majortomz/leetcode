package solution100_199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjw on 2017/9/19.
 */
public class P139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;

        for(String word : wordDict) {
            if(!s.startsWith(word)) continue;
            int index = word.length();
            while(s.startsWith(word, index)) {
                index += word.length();
            }
            if(wordBreak(s.substring(index), wordDict))
                return true;
        }
        return false;
    }


}
