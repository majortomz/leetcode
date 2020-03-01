package solution400_499;

import java.util.*;

/**
 * Created by zjw on 2017/6/27 10:23.
 */
public class P451_SortCharByFreq {

    public String frequencySort(String s) {
        int[][] hash = new int[256][2];
        for(char c : s.toCharArray())
            hash[c][0] += 1;
        for(int i = 0; i < hash.length; i++)
            hash[i][1] = i;
//        Arrays.sort(hash, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0] - o1[0];
//            }
//        });
        Arrays.sort(hash, (x, y) -> y[0] - x[0]);

        StringBuilder sb = new StringBuilder(s.length());

        for(int i = 0; i < hash.length; i++) {
            if(hash[i][0] == 0) break;
            char c = (char)hash[i][1];
            for(int k = 1; k <= hash[i][0]; k++)
                sb.append((c));
        }
        return sb.toString();
    }

}
