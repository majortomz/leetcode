package solution400_499;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjw on 2017/6/26 16:40.
 */
public class P454_4Sum2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;

        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int a: A) {
            for(int b: B) {
                int sum = a + b;
                hash.put(sum, hash.getOrDefault(sum, 0) + 1);
            }
        }

        Arrays.sort(C);
        Arrays.sort(D);
        for(Map.Entry<Integer, Integer> entry: hash.entrySet()) {
            int sum = -entry.getKey(), count = 0;
            int i = 0, j = D.length - 1, countC = 1, countD = 1;
            while(i < C.length && j >= 0) {
                while(i < C.length - 1 && C[i] == C[i+1]) {
                    i++;
                    countC++;
                }
                while(j >= 1 && D[j] == D[j-1]) {
                    j--;
                    countD++;
                }
                if(C[i] + D[j] > sum) {
                    j--;
                    countD = 1;
                }
                else if(C[i] + D[j] < sum) {
                    countC = 1;
                    i++;
                }
                else {
                    count += countC * countD;
                    i++;
                    j--;
                    countC = countD = 1;
                }
            }
            res += entry.getValue() * count;
        }
        return res;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                hash.put(sum, hash.getOrDefault(sum, 0) + 1);
            }
        }

        for(int c : C) {
            for(int d : D) {
                res += hash.getOrDefault(-(c+d), 0);
            }
        }

        return res;
    }


}
