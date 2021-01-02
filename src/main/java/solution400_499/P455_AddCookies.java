package solution400_499;

import java.util.Arrays;

/**
 * Created by zjw on 2018/02/02 14:05
 * Description:
 */
public class P455_AddCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0, index = 0;
        for(int i = 0; i < g.length; i++) {
            int tmp = helper(s, index, g[i]);
            if(tmp == -1) {
                break;
            } else {
                count++;
                index = tmp + 1;
            }
        }
        return count;
    }

    private int helper(int[] s, int start, int key) {
        int end = s.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(s[mid] >= key && (mid == start || s[mid - 1] < key)) {
                return mid;
            }
            if(s[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
