package solution700_799;

/**
 * Created by zjw on 2018/03/04 11:45
 * Description:
 */
public class P794_ValidTicTacToe {

    public boolean validTicTacToe(String[] board) {
        char[][] mat = new char[3][3];
        for(int i = 0; i < mat.length; i++) {
            mat[i] = board[i].toCharArray();
        }

        int numO = 0, numX = 0;
        int count = 0;
        char c = ' ';
        // 对角线
        if(mat[0][0] != ' ' && mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2]) {
            c = mat[1][1];
            count++;
        }
        if(mat[1][1] != ' ' && mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0]) {
            c = mat[1][1];
            count++;
        }
        // 横、竖、记录X和O的数目
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                if(mat[i][j] == 'X')    numX++;
                else if(mat[i][j] == 'O')   numO++;
            }
            if(mat[i][0] != ' ' && mat[i][0] == mat[i][1] && mat[i][1] == mat[i][2]) {
                count++;
                c = mat[i][0];
            }
            if(mat[0][i] != ' ' && mat[0][i] == mat[1][i] && mat[1][i] == mat[2][i]) {
                count++;
                c = mat[0][i];
            }
            if(count > 1)   return false;
        }
        if(c == ' ') {
            return numX == numO || numX == numO + 1;
        } else {
            return c == 'X' && numX == numO + 1 || c == 'O' && numX == numO;
        }
    }

}
