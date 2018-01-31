package solution400_499;

/**
 * Created by zjw on 2018/01/27 16:53
 * Description:
 */
public class P419_BattleshipsInBoard {

    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int count = 0;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                count++;
                board[i][j] = '.';
                for(int k = j + 1; k < n && board[i][k] != '.'; k++) {
                    board[i][k] = '.';
                }
                for(int k = i + 1; k < m && board[k][j] != '.'; k++) {
                    board[k][j] = '.';
                }
            }
        }
        return count;
    }

    // O(1) memory, and one-pass, without modifying the board
    public int countBattleships2(char[][] board) {
        if(board == null || board.length == 0) {
            return 0;
        }
        int m = board.length, n = board[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') continue;
                if(i > 0 && board[i - 1][j] == 'X') continue;
                if(j > 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }
        return count;
    }

}
