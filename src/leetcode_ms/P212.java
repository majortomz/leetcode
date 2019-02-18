package leetcode_ms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zjw on 2018/08/04 21:22
 * Description: Word Search II
 */
public class P212 {

    class TreeNode {
        boolean end = false;
        TreeNode[] childs = new TreeNode[26];
    }

    private void buildTire(TreeNode root, String[] words) {
        for(String word: words) {
            TreeNode cur = root;
            for(char c: word.toCharArray()) {
                if(cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new TreeNode();
                }
                cur = cur.childs[c - 'a'];
            }
            cur.end = true;
        }
    }

    private void dfs(char[][] board, boolean[][] visited, TreeNode cur, Set<String> res, StringBuilder path, int i, int j) {

        char c = board[i][j];
        if(visited[i][j] || cur.childs[c - 'a'] == null) {
            return;
        }

        visited[i][j] = true;
        path.append(board[i][j]);
        if(cur.childs[c - 'a'].end) {
            res.add(path.toString());
        }

        cur = cur.childs[c - 'a'];
        if(i > 0) {
            dfs(board, visited, cur, res, path, i - 1, j);
        }
        if(i + 1 < board.length) {
            dfs(board, visited, cur, res, path, i + 1, j);
        }
        if(j > 0) {
            dfs(board, visited, cur, res, path, i, j - 1);
        }
        if(j + 1 < board[0].length) {
            dfs(board, visited, cur, res, path, i, j + 1);
        }

        visited[i][j] = false;
        path.deleteCharAt(path.length() - 1);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if(board == null || board.length == 0) {
            return new ArrayList<>(res);
        }

        TreeNode root = new TreeNode();

        buildTire(root, words);
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, new boolean[m][n], root, res, new StringBuilder(), i, j);
            }
        }
        return new ArrayList<>(res);
    }


}
