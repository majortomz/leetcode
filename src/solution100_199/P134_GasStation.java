package solution100_199;

import java.util.Arrays;

/**
 * Created by zjw on 2017/9/27.
 */
public class P134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curGasSum = 0, start = 0;
        while(start < cost.length) {
            int oldStart = start;
            boolean valid = true;
            for(int i = 0; i < cost.length; i++) {
                int pos = (start + i) % cost.length;
                curGasSum += (gas[pos] - cost[pos]);
                if(curGasSum < 0) {
                    start = pos + 1;
                    curGasSum = 0;
                    valid = false;
                    break;
                }
            }
            // 处理找到目标位置的情况
            if(valid && oldStart == start)   return start;
            // 处理下一个目标位置小于当前位置的情况
            else if(start <= oldStart)  return -1;
        }

        return -1;
    }

}
