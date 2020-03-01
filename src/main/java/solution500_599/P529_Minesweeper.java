package solution500_599;

/**
 * Created by zjw on 2017/12/6.
 */
public class P529_Minesweeper {

    // M, E, B, 1-8, X
    //        if(row < 0 || row >= height || col < 0 || col >= width || board[row][col] != 'E')
    //            return;
    public char[][] updateBoard(char[][] board, int[] click) {
        helper(board, click[0], click[1]);
        return board;
    }

    public void helper(char[][] board, int row, int col) {
        int height = board.length, width = board[0].length;
        if(board[row][col] == 'M') {
            board[row][col] = 'X';
            return;
        }

        board[row][col] = 'B';
        int num = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int ni = row + i, nj = col + j;
                if((ni == row && nj == col) || ni < 0 || ni >= height || nj < 0 || nj >= width)
                    continue;
                if(board[ni][nj] == 'M')
                    num++;
            }
        }
        if(num > 0) {
            board[row][col] = (char)('0' + num);
        }
        else {
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    int ni = row + i, nj = col + j;
                    if((ni == row && nj == col) || ni < 0 || ni >= height || nj < 0 || nj >= width)
                        continue;
                    if(board[ni][nj] == 'E') {
                        helper(board, ni, nj);
                    }
                }
            }
        }
    }

}
