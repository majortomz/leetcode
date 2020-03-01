package solution300_399;

/**
 * Created by zjw on 2017/10/23.
 */
public class P318_MaxProductOfWordLengths {

    public int maxProduct(String[] words) {
        int res = 0;
        int[] flag = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                flag[i] |= 1 << (c - 'a');
            }
        }
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if((flag[i] & flag[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

}
