package solution200_299;

/**
 * Created by zjw on 2017/10/31.
 */
public class P275_Hindex {

    public int hIndex(int[] citations) {
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
        return 0;
    }

    public int hIndex2(int[] citations) {
        int len = citations.length;
        int count = 0;
        for(int i = len - 1; i >= 0; i--) {
            count++;

            int last = (i == 0 ? citations[i] : citations[i-1] + 1);
            for(int k = citations[i]; k >= last; k--) {
                if(count >= k)
                    return k;
            }
        }
        return count;
    }
}
