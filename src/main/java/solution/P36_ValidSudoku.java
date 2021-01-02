package solution;

/**
 * Created by zjw on 2017/9/22.
 */
public class P36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0)  return false;

        boolean[][] column = new boolean[board[0].length][10];
        for(int i = 0; i < board.length; i++) {
            boolean[] isExists = new boolean[10];
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.')  continue;
                int val = board[i][j] - '0';
                if(isExists[val] || column[j][val])
                    return false;
                isExists[val] = true;
                column[j][val] = true;
            }
        }

        for(int i = 1; i < board.length; i += 3) {
            for(int j = 1; j < board.length; j += 3) {
                boolean isExists[] = new boolean[10];
                for(int m = -1; m <= 1; m++) {
                    int ni = i + m, nj;
                    if(ni < 0 || ni >= board.length)    continue;
                    for(int n = -1; n <= 1; n++) {
                        nj = j + n;
                        if(nj < 0 || nj >= board[0].length || board[ni][nj] == '.')    continue;
                        int val = board[ni][nj] - '0';
                        if(isExists[val])   return false;
                        isExists[val] = true;
                    }
                }
            }
        }
        return true;
    }

}
