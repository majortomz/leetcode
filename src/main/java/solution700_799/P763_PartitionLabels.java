package solution700_799;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zjw on 2018/04/21 16:30
 * Description:
 */
public class P763_PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[][] index = new int[26][2];
        for(int i = 0; i < 26; i++) {
            index[i][0] = -1;
        }
        for(int i = 0; i < S.length(); i++) {
            int k = S.charAt(i) - 'a';
            if(index[k][0] == -1) {
                index[k][1] = index[k][0] = i;
            } else {
                index[k][1] = i;
            }
        }

        Arrays.sort(index, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int i = 0, start = -1, end = -1;
        while(i < 26 && index[i][0] == -1) {
            i++;
        }
        while(i < 26) {
            // System.out.println(index[i][0] + " " + index[i][1]);
            if(index[i][0] > end) {
                res.add(end - start + 1);
                start = index[i][0];
                end = index[i][1];
            } else {
                end = Math.max(index[i][1], end);
            }
            i++;
        }
        res.remove(0);
        res.add(end - start + 1);
        return res;
    }

    // solution 2
    public List<Integer> partitionLabels3(String S) {
        List<Integer> res = new ArrayList<>();
        int[] lastIndex = new int[26];

        for(int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        int last = 0, start = 0;
        for(int i = 0; i < S.length(); i++) {
            last = Math.max(last, lastIndex[S.charAt(i) - 'a']);
            if(last == i) {
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;
    }


}
