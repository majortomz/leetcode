package leetcode_ms;

/**
 * Created by zjw on 2018/08/03 16:48
 * Description:
 */
public class P151 {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if(i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
