package leetcode_ms;

/**
 * Created by zjw on 2018/08/06 9:21
 * Description:
 */
public class P79 {

    public boolean exist(char[][] board, String word) {
        if(word == null || board == null || board.length == 0) {
            return false;
        }

        int m = board.length, n = board[0].length;
        char[] str = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(board, new boolean[m][n], i, j, str, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, boolean[][] visited, int i, int j, char[] str, int k) {
        if(k >= str.length) {
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || str[k] != board[i][j]) {
            return false;
        }

        visited[i][j] = true;
        boolean res = false;
        if(helper(board, visited, i - 1, j, str, k + 1) || helper(board, visited, i + 1, j, str, k + 1)
                || helper(board, visited, i, j - 1, str, k + 1) || helper(board, visited, i, j + 1, str, k + 1)) {
            res = true;
        }
        visited[i][j] = false;
        return res;
    }

}
