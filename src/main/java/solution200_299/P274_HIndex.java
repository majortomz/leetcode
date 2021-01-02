package solution200_299;

import java.util.Arrays;

/**
 * Created by zjw on 2017/10/31.
 */
public class P274_HIndex {

    public int hIndex(int[] citations) {

        if(citations.length == 0)   return 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            int temp = citations[i], count = citations.length - i;
            if(temp >= count) {
                return count;
            }
            while(i + 1 < citations.length && citations[i+1] == temp) {
                i++;
                count--;
                if(temp == count)   return count;
            }
        }
        return citations[citations.length - 1];
    }

    // 0 <= h <= n
    public int hIndex2(int[] citations) {
        if(citations.length == 0)   return 0;
        int[] arr = new int[citations.length + 1];
        for(int num : citations) {
            if(num >= citations.length) arr[citations.length]++;
            else    arr[num]++;
        }

        int count = 0;
        for(int i = citations.length; i >= 0; i--) {
            count += arr[i];
            if(count >= i)  return i;
        }
        return 0;
    }

}
