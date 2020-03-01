package solution200_299;

/**
 * Created by zjw on 2017/6/9.
 */
public class P289_GameOfLife {

    // 0: 0->0
    // 1: 1->1
    // 2: 1->0
    // 3: 0->1
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int[][] go = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int hei = board.length, width = board[0].length;
        for(int i = 0; i < hei; i++) {
            for(int j = 0; j < width; j++) {
                int count = 0;
                for(int k = 0; k < go.length; k++) {
                    int ni = i + go[k][0], nj = j + go[k][1];
                    if(ni < 0 || ni >= hei || nj < 0 || nj >= width)  continue;
                    if(board[ni][nj] == 1 || board[ni][nj] == 2)
                        count++;
                }

                if(board[i][j] == 0) {
                    // revive
                    if(count == 3) board[i][j] = 3;
                }
                else {
                    // live to death
                    if(count < 2 || count > 3)  board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < hei; i++) {
            for(int j = 0; j < width; j++) {
                if(board[i][j] == 2)    board[i][j] = 0;
                else if(board[i][j] == 3)   board[i][j] = 1;
            }
        }
    }
}
