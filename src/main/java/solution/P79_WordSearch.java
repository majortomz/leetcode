package solution;

/**
 * Created by zjw on 2017/5/27.
 */
public class P79_WordSearch {

    int go[][] = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    int height, width;

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        height = board.length;
        width = board[0].length;
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(board[i][j] != word.charAt(0))
                    continue;
                boolean[][] visited = new boolean[height][width];
                if(search(board, word, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int x, int y, int len, boolean[][] visited) {
        if(board[x][y] != word.charAt(len))
            return false;
        len ++;
        if(len == word.length())
            return true;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++)
        {
            int nx = x + go[i][0], ny = y + go[i][1];
            if(nx >=0 && nx < height && ny >=0 && ny < width && !visited[nx][ny])
            {
                if(search(board, word, nx, ny, len, visited))
                    return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
