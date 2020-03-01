package solution800_899;

/**
 * Created by zjw on 2018/04/29 9:34
 * Description:
 */
public class P824_GoatLatin {

    public String toGoatLatin(String S) {
        StringBuilder res = new StringBuilder();
        if(S == null || S.length() == 0) {
            return res.toString();
        }

        String postfix = "", vowels = "aeiouAEIOU";
        char[] words = S.toCharArray();
        for(int i = 0; i < words.length; i++) {
            if(words[i] == ' ') {
                res.append(' ');
                continue;
            }
            if(vowels.indexOf(words[i]) != -1) {
                for(int j = i; j < words.length && words[j] != ' '; j++) {
                    i = j;
                    res.append(words[j]);
                }
            } else {
                char c = words[i];
                for(int j = i + 1; j < words.length && words[j] != ' '; j++) {
                    i = j;
                    res.append(words[j]);
                }
                res.append(c);
            }
            postfix += "a";
            res.append("ma").append(postfix);
        }
        return res.toString();
    }

}
