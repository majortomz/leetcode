package solution800_899;

import java.util.*;

/**
 * Created by zjw on 2018/08/02 20:21
 * Description:
 */
public class P874_WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();

        for (int[] obs : obstacles) {
            if (!rowMap.containsKey(obs[0])) {
                rowMap.put(obs[0], new HashSet<>());
            }
            rowMap.get(obs[0]).add(obs[1]);
        }

        int i = 0, j = 0, dir = 0; // 0 north, 1 east, 2 south, 3 west
        int res = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                dir = dir == 0 ? 3 : dir - 1;
            } else if (cmd == -1) {
                dir = dir == 3 ? 0 : dir + 1;
            } else {
                if (dir == 3) {
                    int target = i - cmd;
                    while (i > target) {
                        if (rowMap.containsKey(i - 1) && rowMap.get(i - 1).contains(j)) {
                            break;
                        }
                        i--;
                    }
                } else if (dir == 1) {
                    int target = i + cmd;
                    while (i < target) {
                        if (rowMap.containsKey(i + 1) && rowMap.get(i + 1).contains(j)) {
                            break;
                        }
                        i++;
                    }
                } else if (dir == 0) {
                    int target = j + cmd;
                    while (j < target) {
                        if (rowMap.containsKey(i) && rowMap.get(i).contains(j + 1)) {
                            break;
                        }
                        j += 1;
                    }
                } else if(dir == 2) {
                    int target = j - cmd;
                    while (j > target) {
                        if (rowMap.containsKey(i) && rowMap.get(i).contains(j - 1)) {
                            break;
                        }
                        j -= 1;
                    }
                }
                res = Math.max(res, i * i + j * j);
            }
        }

        return res;
    }

}
