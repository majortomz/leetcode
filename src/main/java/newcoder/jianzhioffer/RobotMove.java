package newcoder.jianzhioffer;

/**
 * Created by zjw on 2018/03/10 13:06
 * Description:
 */
public class RobotMove {

    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows <= 0 || cols <= 0)    return 0;
        return helper(new boolean[rows][cols], 0, 0, threshold);
    }

    public int helper(boolean[][] visited, int row, int col, int threshold) {
        if(row < 0 || row >= visited.length || col < 0 || col >= visited[0].length || visited[row][col])
            return 0;
        visited[row][col] = true;

        int sum = 0;
        sum += sumDigits(row);
        sum += sumDigits(col);
        if(sum > threshold)    return 0;

        int count = 0;
        count += 1;
        count += helper(visited, row, col - 1, threshold);
        count += helper(visited, row, col + 1, threshold);
        count += helper(visited, row - 1, col, threshold);
        count += helper(visited, row + 1, col, threshold);
        return count;
    }

    private int sumDigits(int a) {
        int sum = 0;
        while(a > 0) {
            sum += (a % 10);
            a /= 10;
        }
        return sum;
    }
}
