package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/04/23 10:28
 * Description: 矩阵中的路径
 */
public class HashPath {

    int len, width;
    char[] matrix, str;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        len = rows;
        width = cols;
        this.matrix = matrix;
        this.str = str;
        for(int i = 0; i < matrix.length; i++) {
            if(helper(i, 0, new boolean[matrix.length]))
                return true;
        }
        return false;
    }

    /**
     *
     * @param index 当前遍历位置的matrix下标
     * @param start str的下标
     * @param visited 是否遍历过
     * @return
     */
    public boolean helper(int index, int start, boolean[] visited) {
        if(start >= str.length) {
            return true;
        }

        if(index < 0 || index >= matrix.length || visited[index] || str[start] != matrix[index]) {
            return false;
        }

        visited[index] = true;
        // 左、右、上、下
        boolean res = helper(index - 1, start + 1, visited) || helper(index + 1, start + 1, visited)
                || helper(index - width, start + 1, visited) || helper(index + width, start + 1, visited);
        visited[index] = false;
        return res;
    }

    public static void main(String[] args) {
        HashPath hp = new HashPath();
        hp.hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray());
    }
}
