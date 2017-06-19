package solution500_599;

import java.util.ArrayList;

/**
 * Created by zjw on 2017/6/16 16:47.
 */
public class P500_KeyboardRow {

    public String[] findWords(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        int[] map = new int[128];
        char[][] board = {
                {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
        };
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                map[board[i][j] - 32] = map[board[i][j]] = i + 1;
            }
        }
        for(String word: words) {
            if(word.length() == 0) {
                res.add(word);
                continue;
            }
            int line = map[word.charAt(0)], i = 1;
            for(i = 1; i < word.length(); i++) {
                if(map[word.charAt(i)] != line)
                    break;
            }
            if(i >= word.length())
                res.add(word);
        }
        String[] arr = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

}
