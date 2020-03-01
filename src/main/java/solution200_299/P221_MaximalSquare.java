package solution200_299;

import java.util.*;

/**
 * Created by zjw on 2018/01/13 15:25
 * Description:
 */
public class P221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int height = matrix.length, width = matrix[0].length;
        int area = 0, bound = Math.min(height, width);
        List<Set<List<Integer>>> list = new ArrayList<>();
        list.add(new HashSet<>());
        list.add(init(matrix));

        if (list.get(1).size() == 0) {
            return area;
        }
        area = 1;
        for (int i = 2; i <= bound; i++) {
            Set<List<Integer>> set = new HashSet<>();
            int half = i / 2;
            for (List<Integer> pos : list.get(half)) {
                List<Integer> pos1 = Arrays.asList(pos.get(0), pos.get(1) + half);
                List<Integer> pos2 = Arrays.asList(pos.get(0) + half, pos.get(1));
                List<Integer> pos3 = Arrays.asList(pos.get(0) + half, pos.get(1) + half);
                if (list.get(half).contains(pos) && list.get(i - half).contains(pos1)
                        && list.get(i - half).contains(pos2) && list.get(i - half).contains(pos3)) {
                    set.add(pos);
                }
            }
            if (set.size() == 0) {
                break;
            } else {
                list.add(set);
                area = i;
            }
        }
        return area * area;
    }

    private Set<List<Integer>> init(char[][] matrix) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    set.add(Arrays.asList(i, j));
                }
            }
        }
        return set;
    }

    private class Solution2 {
        public int maximalSquare(char[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int height = matrix.length, width = matrix[0].length;
            int[][] dp = new int[height][width];
            int max = 0;

            for(int i = 0; i < height; i++) {
                dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
                max = Math.max(dp[i][0], max);
            }
            for(int i = 0; i < width; i++) {
                dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
                max = Math.max(dp[0][i], max);
            }

            for(int i = 1; i < height; i++) {
                for(int j = 1; j < width; j++) {
                    if(matrix[i][j] == '0') {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
            return max * max;
        }
    }

}
