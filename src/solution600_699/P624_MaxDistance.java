package solution600_699;

import java.util.List;

/**
 * Created by zjw on 2017/6/21 09:59.
 */
public class P624_MaxDistance {

    public int maxDistance(List<List<Integer>> arrays) {
        int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE}, max = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] minI = new int[2], maxI = new int[2];
        for(int i = 0; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int tmpMin = arr.get(0), tmpMax = arr.get(arr.size() - 1);
            if(tmpMax >= max[0]) {
                maxI[1] = maxI[0];   max[1] = max[0];
                maxI[0] = i; max[0] = tmpMax;
            }
            else if(tmpMax >= max[1]) {
                maxI[1] = i;   max[1] = tmpMax;
            }

            if(tmpMin <= min[0]) {
                minI[1] = minI[0]; min[1] = min[0];
                minI[0] = i; min[0] = tmpMin;
            }
            else if(tmpMin < min[1]) {
                minI[1] = i; min[1] = tmpMin;
            }
        }
        if(minI[0] != maxI[0])
            return Math.abs(max[0] - min[0]);
        else
            return Math.max(Math.abs(max[1] - min[0]), Math.abs(max[0] - min[1]));
    }

    public int maxDistance2(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        int dis = Integer.MIN_VALUE;
        for(int i = 1; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int tmpMin = arr.get(0), tmpMax = arr.get(arr.size() - 1);
            dis = Math.max(dis, Math.abs(max - tmpMin));
            dis = Math.max(dis, Math.abs(tmpMax - min));
            min = Math.min(min, tmpMin);
            max = Math.max(max, tmpMax);
        }
        return dis;
    }

}
