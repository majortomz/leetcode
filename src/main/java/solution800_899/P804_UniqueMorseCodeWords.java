package solution800_899;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zjw on 2018/03/25 9:43
 * Description:
 */
public class P804_UniqueMorseCodeWords {

    private static String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
            ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        if(words == null || words.length == 0)  return 0;
        Set<String> set = new HashSet<>();
        for(String word : words) {
            StringBuilder builder = new StringBuilder();
            for(char item : word.toCharArray()) {
                builder.append(codes[item - 'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }

}
